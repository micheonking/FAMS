package myApp.client.vi.itm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.sencha.gxt.core.client.Style.SelectionMode;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.CellDoubleClickEvent;
import com.sencha.gxt.widget.core.client.event.CellDoubleClickEvent.CellDoubleClickHandler;
import com.sencha.gxt.widget.core.client.event.CollapseEvent;
import com.sencha.gxt.widget.core.client.event.CollapseEvent.CollapseHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;

import myApp.client.grid.ComboBoxField;
import myApp.client.grid.GridBuilder;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.InterfaceCallback;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.LoginUser;
import myApp.client.vi.itm.model.Itm01_ItmModel;
import myApp.client.vi.itm.model.Itm01_ItmModelProperties;

public class Itm01_Lookup_Itm extends Window implements InterfaceServiceCall {

	private ComboBoxField abroTypComboBox;
	private ComboBoxField lClassTypComboBox;
	private TextField itmName = new TextField();
	
	private Grid<Itm01_ItmModel> grid = this.buildGrid();
	private InterfaceCallbackResult callback;
	
	public void open (String itmLClassCode, InterfaceCallbackResult callback) {

		this.callback = callback;

		this.setModal(false);
		this.setResizable(true);
		this.setPixelSize(550, 500);

		boolean isReadOnly;
		if(itmLClassCode == null) {
			this.setHeading("종목코드(공통)");
			isReadOnly = false;
		} else {
			this.setHeading("종목코드("+itmLClassCode+")");
			isReadOnly = true;
		}
		
		ButtonBar searchBar = new ButtonBar(); 

		//-------------------------------------------------------------------
		//	종목대분류 ComboBox SET
		//-------------------------------------------------------------------
		lClassTypComboBox = new ComboBoxField("LCLASS_CD", new InterfaceCallback() {
			@Override
			public void execute() {
				if(itmLClassCode != null) {
					lClassTypComboBox.setText(itmLClassCode);
				}
			}
		});
		lClassTypComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				itmName.setText(null);
//				grid.getStore().clear();
				retrieve();
			}
		});
		lClassTypComboBox.setWidth(100);
		lClassTypComboBox.setReadOnly(isReadOnly);
		FieldLabel lClassTypField = new FieldLabel(lClassTypComboBox, "검색 ");
		lClassTypField.setWidth(140);
		lClassTypField.setLabelWidth(40);
		searchBar.add(lClassTypField);
		
		//-------------------------------------------------------------------
		//	국내외구분 ComboBox SET
		//-------------------------------------------------------------------
		abroTypComboBox = new ComboBoxField("ABRO_TYP_CD", new InterfaceCallback() {
			@Override
			public void execute() {
				retrieve();
			}
		});
		abroTypComboBox.addCollapseHandler(new CollapseHandler() {
			@Override
			public void onCollapse(CollapseEvent event) {
				itmName.setText(null);
//				grid.getStore().clear();
				retrieve();
			}
		});
		abroTypComboBox.setWidth(80);
		searchBar.add(abroTypComboBox);

		//-------------------------------------------------------------------
		//	검색 TextField SET
		//-------------------------------------------------------------------
		itmName.setEmptyText("전체");
		itmName.setWidth(200);
		itmName.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getCharCode() == 13) {
					retrieve();
				}
			}
		});
		searchBar.add(itmName);
		
		//-------------------------------------------------------------------
		//	조회 Button SET
		//-------------------------------------------------------------------
		TextButton retrieveButton = new TextButton("조회");
		retrieveButton.setWidth(50);
		retrieveButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				retrieve();
			}
		});
		searchBar.add(retrieveButton);

		//-------------------------------------------------------------------
		//	Grid SET
		//-------------------------------------------------------------------
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(searchBar, new VerticalLayoutData(1, 50));
		vlc.add(grid, new VerticalLayoutData(1, 1));
		
		this.add(vlc);

		TextButton okButton = new TextButton("확인");
		okButton.setWidth(50);
		okButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				confirm();
			}
		});
		this.addButton(okButton);

		TextButton cancelButton = new TextButton("취소");
		cancelButton.setWidth(50);
		cancelButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				hide();
			}
		});
		this.addButton(cancelButton);
		this.setButtonAlign(BoxLayoutPack.CENTER);
		
		this.grid.addCellDoubleClickHandler(new CellDoubleClickHandler() {
			@Override
			public void onCellClick(CellDoubleClickEvent event) {
				confirm(); 
			}
		}); 
		
		this.show();
	}

	private Grid<Itm01_ItmModel> buildGrid() {
		Itm01_ItmModelProperties properties = GWT.create(Itm01_ItmModelProperties.class);
		GridBuilder<Itm01_ItmModel> gridBuilder = new GridBuilder<Itm01_ItmModel>(properties.keyId());
		gridBuilder.setChecked(SelectionMode.SINGLE);
		gridBuilder.addText(properties.itmCode(), 150, "종목코드");
		gridBuilder.addText(properties.itmAbbr(), 300, "종목명");
		return gridBuilder.getGrid();
	}

	private void retrieve() {
		
		grid.mask("Loading");
		
		GridRetrieveData<Itm01_ItmModel> service = new GridRetrieveData<Itm01_ItmModel>(grid.getStore());
		String itmName = this.itmName.getText() ; 
		if(itmName != null) {
			itmName = "%" + itmName + "%";  
		}
		else {
			itmName = "%"; 
		}
		service.addParam("searchText", itmName);
		service.addParam("abroTypCode", abroTypComboBox.getCode());
		service.addParam("lClassCode", lClassTypComboBox.getCode());
		service.addParam("cmpCode", LoginUser.getCmpCode());
		service.retrieve("itm.Itm01_Itm.selectBySearchText", new InterfaceCallback() {
			@Override
			public void execute() {
				grid.unmask();
			}
		});
	}

	protected void confirm() {
		if(this.callback != null) {
			Itm01_ItmModel selectModel = this.grid.getSelectionModel().getSelectedItem(); 
			if(selectModel != null) {
				this.callback.execute(selectModel);
			}
			else {
				new SimpleMessage("선택한 종목이 없습니다."); 
				return; 
			}
		}
		this.hide(); 
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		if(result.getStatus() > 0 ) {
			callback.execute(null);
			this.hide(); 
		}
		else {
			new SimpleMessage("error"); 
		}
	}
}
