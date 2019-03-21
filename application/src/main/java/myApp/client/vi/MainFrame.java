package myApp.client.vi;

import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.tree.Tree;

import myApp.client.resource.ResourceIcon;
import myApp.client.vi.sys.model.Sys04_CmpMenuModel;

public class MainFrame extends BorderLayoutContainer {

	private MainFrameNorthLayout mainFrameNorthLayout = new MainFrameNorthLayout();
	private MainFrameSouthLayout mainFrameSouthLayout = new MainFrameSouthLayout();

	private TabPanel tabPanel = new TabPanel();
	private MenuTree treeMenu = new MenuTree(tabPanel);
	
	private TextField searchText = new TextField();

	public MainFrame getMainWindow() {
		
		this.setBorders(true);
		
		//------------------------------------------------------------
		// North setting
		//------------------------------------------------------------
		BorderLayoutData northLayoutData = new BorderLayoutData(60);
		northLayoutData.setMargins(new Margins(0,0,0,0));
		this.setNorthWidget(mainFrameNorthLayout, northLayoutData); 
		
		//------------------------------------------------------------
		// West setting 
		//------------------------------------------------------------
		BorderLayoutData westLayoutData = new BorderLayoutData(250);
		westLayoutData.setMargins(new Margins(2, 2, 2, 2)); // 앞쪽에 보이는 가로 줄을 없애준다
		westLayoutData.setCollapsible(true);
		westLayoutData.setCollapseHeaderVisible(true);
		westLayoutData.setSplit(true);
		this.setWestWidget(this.getWestLayout(), westLayoutData);

		//------------------------------------------------------------
		// Center setting 
		//------------------------------------------------------------
		tabPanel.setTabScroll(true);
		tabPanel.add(new TabBorder(), "My Page"); // my page setting
		VerticalLayoutContainer vlc = new VerticalLayoutContainer(); 
		vlc.add(tabPanel, new VerticalLayoutData(1, 1, new Margins(4,4,0,0)));
		this.setCenterWidget(vlc);
		
		//------------------------------------------------------------
		// South setting 
		//------------------------------------------------------------
		BorderLayoutData southLayoutData = new BorderLayoutData(25);
		southLayoutData.setMargins(new Margins(4, 2, 2, 2)); // 앞쪽에 보이는 가로 줄을 없애준다
		this.setSouthWidget(mainFrameSouthLayout, southLayoutData);

		return this; 
	}
	
	private ContentPanel getWestLayout() {

		AccordionLayoutAppearance accordianLayout = GWT.create(AccordionLayoutAppearance.class);

		TextButton searchButton = new TextButton("찾기");
		searchButton.setIcon(ResourceIcon.INSTANCE.search16Button());
		searchButton.addSelectHandler(new SelectHandler(){
			@Override
			public void onSelect(SelectEvent event) {
				searchClass();
			}
		});
		searchText.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getCharCode() == 13) {
					searchClass();
				}
			}
		});

		ButtonBar searchBar = new ButtonBar();
		searchBar.add(searchText);
		searchBar.add(searchButton);

		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(this.treeMenu.getMenuTree(), new VerticalLayoutData(1,1,new Margins(0)));
		vlc.add(searchBar, new VerticalLayoutData(1,50,new Margins(0)));

		ContentPanel treeAccordianPanel = new ContentPanel(accordianLayout);
		treeAccordianPanel.setHeading("Menu Navigation");
		treeAccordianPanel.getHeader().setHeight(16);
		treeAccordianPanel.add(vlc);

		AccordionLayoutContainer accordianContainer = new AccordionLayoutContainer();
		accordianContainer.setExpandMode(ExpandMode.SINGLE_FILL);
//		accordianContainer.setHideCollapseTool(true); // 감추기 버튼 감추기
//		accordianContainer.setTitleCollapse(false); // 감추기 버튼 작동안하기 
		accordianContainer.add(treeAccordianPanel);
		accordianContainer.setActiveWidget(treeAccordianPanel);

		return treeAccordianPanel;
	}

	protected void searchClass() {

		Tree<Sys04_CmpMenuModel, String> tree = treeMenu.getMenuTree();
		tree.getSelectionModel().deselectAll();
		tree.collapseAll();
		
		String findText = searchText.getText();
		if((findText == null) || ("".equals(findText))) {
			return;
		}
		
		List<Sys04_CmpMenuModel> list = tree.getStore().getAll();
		for(Sys04_CmpMenuModel findModel : list) {
			if(findModel.getMenuName().indexOf(findText) > -1) {
				Sys04_CmpMenuModel prntModel = tree.getStore().getParent(findModel);
				if(prntModel != null) {
					tree.setExpanded(prntModel, true);
				}
				tree.getSelectionModel().select(findModel, true);
			}
		}
	}

}
