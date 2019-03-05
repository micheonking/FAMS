package myApp.client.vi;

import com.google.gwt.core.shared.GWT;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.AccordionLayoutAppearance;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer.ExpandMode;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class MainFrame extends BorderLayoutContainer {

	private MainFrameNorthLayout mainFrameNorthLayout = new MainFrameNorthLayout();
	private MainFrameSouthLayout mainFrameSouthLayout = new MainFrameSouthLayout();

	private TabPanel tabPanel = new TabPanel();
	private MenuTree treeMenu = new MenuTree(tabPanel); 

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
		vlc.add(tabPanel, new VerticalLayoutData(1, 1, new Margins(4,4,0,4)));
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

		ContentPanel treeAccordianPanel = new ContentPanel(accordianLayout); 
		treeAccordianPanel.setHeading("Menu Navigation");	
		treeAccordianPanel.getHeader().setHeight(16);
		treeAccordianPanel.add(this.treeMenu.getMenuTree()); // tree menu setting 

		AccordionLayoutContainer accordianContainer = new AccordionLayoutContainer();
		accordianContainer.setExpandMode(ExpandMode.SINGLE_FILL);
		accordianContainer.setHideCollapseTool(true); // 감추기 버튼 감추기
		accordianContainer.setTitleCollapse(false); // 감추기 버튼 작동안하기 
		accordianContainer.add(treeAccordianPanel);
		accordianContainer.setActiveWidget(treeAccordianPanel);

		return treeAccordianPanel;
	}

}
