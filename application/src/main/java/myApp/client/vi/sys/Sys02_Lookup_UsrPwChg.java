package myApp.client.vi.sys;


import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.SimpleMessage;
import myApp.client.vi.sys.model.Sys02_UsrInfoModel;

public class Sys02_Lookup_UsrPwChg extends Window implements Editor<Sys02_UsrInfoModel> , InterfaceServiceCall {

	private InterfaceCallbackResult callback;
	Grid<Sys02_UsrInfoModel> grid;
	ContentPanel contentPanel  = new ContentPanel();
	private String		winWidth  = "300";
    private String 		winHeight = "250";
    Long usrInfoId;
    TextField oldPassWord		 = new TextField();
	TextField newPw		 = new TextField();

	public void open (String oldPw, Long usrInfoId, InterfaceCallbackResult callback) {
		
		this.usrInfoId = usrInfoId;
		oldPassWord.setValue(oldPw);
		this.callback = callback;
		this.setModal(true);
		this.setHeading("비밀번호 변경");
		this.setResizable(false);
		this.setPixelSize(Integer.parseInt(winWidth), Integer.parseInt(winHeight));
		
		ButtonBar searchBar = new ButtonBar(); 
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(searchBar, new VerticalLayoutData(1, 50));
		this.add(vlc);
		
		TextButton okButton = new TextButton("저장");
		okButton.setWidth(50);
		okButton.setHeight(30);
		okButton.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				updatePw();
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
		vlc.add(this.getEditor() , new VerticalLayoutData(1,1, new Margins(5,15,0,15)));
		this.show();
	}	
	
	private IsWidget getEditor() {
		contentPanel.setHeaderVisible(false);
		contentPanel.setBorders(false);
		contentPanel.setSize(winWidth, winHeight);
		
		HorizontalLayoutData labelLayout = new HorizontalLayoutData( 90,  -1, new Margins(2,10,10,0));	//라벨Size
		HorizontalLayoutContainer row01 = new HorizontalLayoutContainer();
		HorizontalLayoutContainer row02 = new HorizontalLayoutContainer();
		
		//현재비밀번호
		row01.add(new LabelToolItem("현재비밀번호 : "), labelLayout);
		row01.add(oldPassWord, new HorizontalLayoutData(160, -1, new Margins(0,10,10,10)));
		oldPassWord.setReadOnly(true);
		
		//신규비밀번호
		row02.add(new LabelToolItem("신규비밀번호 : "), labelLayout);
		row02.add(newPw, new HorizontalLayoutData(160, -1, new Margins(0,10,10,10)));
	
		
		VerticalLayoutContainer layout = new VerticalLayoutContainer();
		layout.add(row01, new VerticalLayoutData(1,  32, new Margins(0,0,20,0)));
		layout.add(row02, new VerticalLayoutData(1,  32, new Margins(20,0,20,0)));
		
		contentPanel.setWidget(layout);
		return contentPanel;
	}

	private void updatePw() {
		ServiceRequest request = new ServiceRequest("sys.Sys02_UsrInfo.userPw");
		request.putLongParam("usrInfoId", usrInfoId);
		request.putStringParam("newPw",newPw.getValue());
		ServiceCall service = new ServiceCall();
		service.execute(request, this);

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
