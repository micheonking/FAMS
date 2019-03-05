package myApp.client.vi;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.sencha.gxt.cell.core.client.TextButtonCell;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.resource.ResourceIcon;
import myApp.client.vi.LoginUser;
import myApp.theme.tritium.custom.client.button.whiteGrey.WhiteGreyButtonCellAppearance;

public class MainFrameNorthLayout extends BorderLayoutContainer {

	Viewport viewport = new Viewport();

	public MainFrameNorthLayout() {

		HBoxLayoutContainer header = new HBoxLayoutContainer();
		header.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);

		//---------------------------------------------------------------------------
		//	LOGO SET
		//---------------------------------------------------------------------------
		Image image = new Image();
		image.setResource(ResourceIcon.INSTANCE.getLogo());
		image.setPixelSize(320, 35);
		header.add(image, new BoxLayoutData(new Margins(5, 0, 0, 20)));

		//---------------------------------------------------------------------------
		//
		//---------------------------------------------------------------------------
		BoxLayoutData boxLayoutData = new BoxLayoutData(new Margins(0, 0, 0, 0)); 
		boxLayoutData.setFlex(1);
		header.add(new Label(), boxLayoutData);
		 
		//---------------------------------------------------------------------------
		//	Login User Info SET
		//---------------------------------------------------------------------------
		String userInfo = LoginUser.getUsrInfoModel().getUsrName() + " 님" ; ;
		userInfo = "<p style='color:#808080; font-size:14px; font-weight:normal'>" + userInfo + "</p>" ; 
		SafeHtml safeEscapedHtml = SafeHtmlUtils.fromTrustedString(userInfo);
		LabelToolItem label = new LabelToolItem(safeEscapedHtml); 
		header.add(label, new BoxLayoutData(new Margins(9, 0, 0, 0)));
		
		//로그아웃
		Label userLogout = new HTML("<p style='color:#808080; font-size:13px; font-weight:normal'><a href=\"#\">[로그아웃] </a></p>");
		userLogout.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final ConfirmMessageBox msgBox = new ConfirmMessageBox("로그아웃", "로그아웃 하시겠습니까?");
				msgBox.addDialogHideHandler(new DialogHideHandler() {
					@Override
					public void onDialogHide(DialogHideEvent event) {
						switch (event.getHideButton()) {
						case YES:
							Window.Location.reload();
							break;
						case NO:
						default:
							break;
						}
					}
				});
				msgBox.setWidth(300);
				msgBox.show();
			}
		});
		header.add(userLogout, new BoxLayoutData(new Margins(9, 30, 0, 0)));

		ContentPanel cp = new ContentPanel();
		cp.setBodyStyle("backgroundColor:white; color:red"); // http://www.w3schools.com/colors/colors_names.asp 페이지 참조

		cp.add(header);
		
		cp.forceLayout();
		cp.setHeaderVisible(false);
		cp.getButtonBar().setHeight(0);
		cp.setBorders(true);
		
		this.add(cp);
	}
}