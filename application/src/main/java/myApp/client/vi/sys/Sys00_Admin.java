package myApp.client.vi.sys;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;

public class Sys00_Admin extends ContentPanel {
	
	public Sys00_Admin() {

		this.setHeading("시스템 관리자");
		this.setBorders(true);
		SafeHtml button1Html = SafeHtmlUtils.fromTrustedString(
				"<div style='border: 1px solid white; padding: 15px; height: auto; '><font color='#ffffff' style='font-size:20px;font-weight:bold'>시스템 관리자</font></div>");

		this.setHeading(button1Html);
//		this.setBodyStyle("backgroundColor:#ffffff; color:#606060"); // http://www.w3schools.com/colors/colors_names.asp 페이지 참조
		
		TabPanel tabPanel = new TabPanel();
		
		Sys01_Tab_Company tabCompany = new Sys01_Tab_Company();
		tabPanel.add(tabCompany, "고객정보");

		Sys06_Tab_Menu tabMenu = new Sys06_Tab_Menu();
		tabPanel.add(tabMenu, "메뉴구성");
		
		Sys08_CodeKind tabCode = new Sys08_CodeKind();
		tabPanel.add(tabCode, "공통코드");
		
		this.add(tabPanel, new MarginData(3));
		
	}
}