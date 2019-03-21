package myApp.client.vi;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.info.Info;

public class MenuOpener {

	private Widget createTab(String className) {

		if ("Sys02_Tab_UsrInfo.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys02_Tab_UsrInfo.class);
		}
		if ("Sys05_Tab_Role.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys05_Tab_Role.class);
		}

		if ("Sys06_Tab_RoleMenu.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys06_Tab_RoleMenu.class);
		}

		if ("Sys07_Tab_UsrRole.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys07_Tab_UsrRole.class);
		}

		if ("Sys08_Tab_DptInfo.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.sys.Sys08_Tab_DptInfo.class);
		}
		
		if ("Com01_Tab_ComCode.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.com.Com01_Tab_ComCode.class);
		}
		
		if ("Com04_Tab_TrCode.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.com.Com04_Tab_TrCode.class);
		}
		
		if ("Com08_Tab_FeeRate.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.com.Com08_Tab_FeeRate.class);
		}
		
		if ("Com09_Tab_TaxRate.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.com.Com09_Tab_TaxRate.class);
		}
		
		if ("Com10_TaxSys.class".equals(className)) {
			return (Widget) GWT.create(myApp.client.vi.com.Com10_TaxSys.class);
		}

		return null;
	}

	public void openTab(TabPanel tabPanel, String className, String pageName) {

		TabItemConfig tabItemConfig = new TabItemConfig(pageName, true);
		Widget tabPage = tabPanel.findItem(pageName, true);

		if (tabPage != null) {
			tabPanel.setActiveWidget(tabPage);
			return;
		}

		// not found tab page
		tabPage = createTab(className);

		if (tabPage != null) {
			tabPanel.add(tabPage, tabItemConfig);
			tabPanel.setActiveWidget(tabPage);
		} else {
			Info.display(pageName, "해당 오브젝트(" + className + ")가 시스템에 등록되어 있지 않습니다.");
		}
	}
}