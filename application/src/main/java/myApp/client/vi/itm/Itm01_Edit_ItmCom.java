package myApp.client.vi.itm;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.ButtonBar;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.LongField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

import myApp.client.field.LookupTriggerField;
import myApp.client.field.MyDateField;
import myApp.client.grid.ComboBoxField;
import myApp.client.resource.ResourceIcon;
import myApp.client.service.GridRetrieveData;
import myApp.client.service.InterfaceCallback;
import myApp.client.service.InterfaceServiceCall;
import myApp.client.service.ServiceCall;
import myApp.client.service.ServiceRequest;
import myApp.client.service.ServiceResult;
import myApp.client.utils.InterfaceCallbackResult;
import myApp.client.utils.InterfaceCallbackResult2;
import myApp.client.vi.LoginUser;
import myApp.client.vi.com.Com00_ItmLookupComboBox;
import myApp.client.vi.itm.model.Itm01_ItmModel;

public class Itm01_Edit_ItmCom extends ContentPanel implements Editor<Itm01_ItmModel>, InterfaceServiceCall {

	Itm01_ItmModel itmModel = new Itm01_ItmModel();
	interface EditDriver extends SimpleBeanEditorDriver<Itm01_ItmModel, Itm01_Edit_ItmCom> {
	}
	EditDriver editDriver = GWT.create(EditDriver.class);

	private String			actionName;
	private InterfaceCallbackResult callbackResult;

	TextField           itmCode                 = new TextField();
	TextField           infoSttDate             = new TextField();
	TextField           infoEndDate             = new TextField();
	TextField           itmName                 = new TextField();
	TextField           itmAbbr                 = new TextField();
	TextField           itmEName                = new TextField();
	TextField           itmEAbbr                = new TextField();
	TextField           isin                    = new TextField();
	TextField           itmShtCode              = new TextField();
	TextField           cusip                   = new TextField();
	TextField           sedol                   = new TextField();
	TextField       	dataRcvCode             = new TextField();
	TextField           cloMonth                = new TextField();
	LongField           par                     = new LongField();
	MyDateField         issDateConv             = new MyDateField();
	MyDateField         matDateConv             = new MyDateField();
	MyDateField         listDateConv            = new MyDateField();
	MyDateField         newRegDateConv          = new MyDateField();
	ComboBoxField       lclassCode              = new ComboBoxField("LCLASS_CD",null," ");
	ComboBoxField       mclassCode              = new ComboBoxField("MCLASS_CD",null," ");
	ComboBoxField       listTypeCode            = new ComboBoxField("LIST_TYP_CD",null," ");
	ComboBoxField       ntnCode                 = new ComboBoxField("NTN_CD",null," ");
	ComboBoxField       areaCode                = new ComboBoxField("AREA_CD",null," ");
	ComboBoxField       krxTypeCode             = new ComboBoxField("KRX_TYP_CD",null," ");
	ComboBoxField       taxTypeCode             = new ComboBoxField("TAX_TYP_CD",null," ");
	ComboBoxField       grtTypeCode             = new ComboBoxField("GRT_TYP_CD",null," ");
	ComboBoxField       whTypeCode              = new ComboBoxField("WH_TYP_CD",null," ");
	ComboBoxField       abroWhTypeCode          = new ComboBoxField("ABRO_WH_TYP_CD",null," ");
	ComboBoxField       payCurCode              = new ComboBoxField("CUR_CD",null," ");
	ComboBoxField       rcvCurCode              = new ComboBoxField("CUR_CD",null," ");
	ComboBoxField       evlCurCode              = new ComboBoxField("CUR_CD",null," ");
	ComboBoxField       pubPrvTypeCode          = new ComboBoxField("PUB_PRV_TYP_CD",null," ");
	ComboBoxField       dataRcvYn               = new ComboBoxField("YN",null," ");
	ComboBoxField       dataRcvPayUntCode       = new ComboBoxField("DATA_RCV_APY_UNT_CD",null," ");
	ComboBoxField       dataRcvCo               = new ComboBoxField("DATA_RCV_CO",null," ");
	ComboBoxField       dealUnt                 = new ComboBoxField("DEAL_UNT",null," ");
	ComboBoxField       evlTypeCode             = new ComboBoxField("EVL_TYP_CD",null," ");
	ComboBoxField       rdmPlCalcTypeCode       = new ComboBoxField("RDM_PL_CALC_TYP_CD",null," ");
	ComboBoxField       mktPrcApyFrmlCode       = new ComboBoxField("MKT_PRC_APY_FRML_CD",null," ");
	ComboBoxField       taxPosTypeCode          = new ComboBoxField("TAX_POS_TYP_CD",null," ");
	ComboBoxField       rcvbIntCalcFrmlCode     = new ComboBoxField("RCVB_INT_CALC_FRML_CD",null," ");
	ComboBoxField       astMngFrmlCode          = new ComboBoxField("AST_MNG_FRML_CD",null," ");
	ComboBoxField       evlFrmlCode             = new ComboBoxField("EVL_FRML_CD",null," ");
//	ComboBoxField       dtlClassCode            = new ComboBoxField();
	LookupTriggerField  issCorpCode             = new LookupTriggerField();
	LookupTriggerField  orgIssCorpCode          = new LookupTriggerField();
	LookupTriggerField  mngCoCode               = new LookupTriggerField();
	LookupTriggerField  grtCorpCode             = new LookupTriggerField();

	public void open() {
		this.setHeaderVisible(false);
		this.setBorders(false);
		editDriver.initialize(this);

		makeForm();
	}

	private void makeForm() {
		
		HorizontalLayoutData labelLayout1 = new HorizontalLayoutData(100, -1, new Margins(10,0,0,0));
		HorizontalLayoutData labelLayout2 = new HorizontalLayoutData(120, -1, new Margins(10,0,0,0));
		HorizontalLayoutData labelLayout3 = new HorizontalLayoutData(130, -1, new Margins(10,0,0,0));
		HorizontalLayoutData fieldLayout1 = new HorizontalLayoutData(180, -1, new Margins(0,5,0,0));
		HorizontalLayoutData fieldLayout2 = new HorizontalLayoutData(180, -1, new Margins(0,5,0,0));
		HorizontalLayoutData fieldLayout3 = new HorizontalLayoutData(200, -1, new Margins(0,5,0,0));
		HorizontalLayoutData termLayout1  = new HorizontalLayoutData( 50, -1, new Margins(0,0,0,0));
		HorizontalLayoutData termLayout2  = new HorizontalLayoutData( 70, -1, new Margins(0,0,0,0));

		//------------------------------------------------------
		// ROW 01
		//------------------------------------------------------
		HorizontalLayoutContainer row01 = new HorizontalLayoutContainer();

		row01.add(new LabelToolItem("종목코드"), labelLayout1);
		row01.add(itmCode, fieldLayout1);

		row01.add(new LabelToolItem(), termLayout1);

		row01.add(new LabelToolItem("종목명(약명/풀명)"), labelLayout2);
		row01.add(itmAbbr, fieldLayout1);
		row01.add(itmName, new HorizontalLayoutData(400, -1, new Margins(0,5,0,0)));

		//------------------------------------------------------
		// ROW 02
		//------------------------------------------------------
		HorizontalLayoutContainer row02 = new HorizontalLayoutContainer();

		row02.add(new LabelToolItem("종목단축코드"), labelLayout1);
		row02.add(itmShtCode, fieldLayout1);

		row02.add(new LabelToolItem(), termLayout1);

		row02.add(new LabelToolItem("영문명(약명/풀명)"), labelLayout2);
		row02.add(itmEAbbr, fieldLayout1);
		row02.add(itmEName, new HorizontalLayoutData(400, -1, new Margins(0,5,0,0)));

		//------------------------------------------------------
		// ROW 03
		//------------------------------------------------------
		HorizontalLayoutContainer row03 = new HorizontalLayoutContainer();

		row03.add(new LabelToolItem("종목대분류"), labelLayout1);
		row03.add(lclassCode, fieldLayout1);

		row03.add(new LabelToolItem(), termLayout1);

		row03.add(new LabelToolItem("국가코드"), labelLayout2);
		row03.add(ntnCode, fieldLayout2);

		row03.add(new LabelToolItem(), termLayout2);

		row03.add(new LabelToolItem("DATA수신여부"), labelLayout3);
		row03.add(dataRcvYn, fieldLayout3);

		//------------------------------------------------------
		// ROW 04
		//------------------------------------------------------
		HorizontalLayoutContainer row04 = new HorizontalLayoutContainer();

		row04.add(new LabelToolItem("종목중분류"), labelLayout1);
		row04.add(mclassCode, fieldLayout1);

		row04.add(new LabelToolItem(), termLayout1);

		row04.add(new LabelToolItem("지역코드"), labelLayout2);
		row04.add(areaCode, fieldLayout2);

		row04.add(new LabelToolItem(), termLayout2);

		row04.add(new LabelToolItem("DATA수신코드"), labelLayout3);
		row04.add(dataRcvCode, fieldLayout3);

		//------------------------------------------------------
		// ROW 05
		//------------------------------------------------------
		HorizontalLayoutContainer row05 = new HorizontalLayoutContainer();

		row05.add(new LabelToolItem("발행일자"), labelLayout1);
		row05.add(issDateConv, fieldLayout1);

		row05.add(new LabelToolItem(), termLayout1);

		row05.add(new LabelToolItem("지급통화"), labelLayout2);
		row05.add(payCurCode, fieldLayout2);

		row05.add(new LabelToolItem(), termLayout2);

		row05.add(new LabelToolItem("DATA수신처"), labelLayout3);
		row05.add(dataRcvCo, fieldLayout3);

		//------------------------------------------------------
		// ROW 06
		//------------------------------------------------------
		HorizontalLayoutContainer row06 = new HorizontalLayoutContainer();

		row06.add(new LabelToolItem("만기일자"), labelLayout1);
		row06.add(matDateConv, fieldLayout1);

		row06.add(new LabelToolItem(), termLayout1);

		row06.add(new LabelToolItem("수령통화"), labelLayout2);
		row06.add(rcvCurCode, fieldLayout2);

		row06.add(new LabelToolItem(), termLayout2);

		row06.add(new LabelToolItem("DATA수신적용단위"), labelLayout3);
		row06.add(dataRcvPayUntCode, fieldLayout3);

		//------------------------------------------------------
		// ROW 07
		//------------------------------------------------------
		HorizontalLayoutContainer row07 = new HorizontalLayoutContainer();

		row07.add(new LabelToolItem("상장구분"), labelLayout1);
		row07.add(listTypeCode, fieldLayout1);

		row07.add(new LabelToolItem(), termLayout1);

		row07.add(new LabelToolItem("평가통화"), labelLayout2);
		row07.add(evlCurCode, fieldLayout2);

		row07.add(new LabelToolItem(), termLayout2);

		row07.add(new LabelToolItem("시세적용방식"), labelLayout3);
		row07.add(mktPrcApyFrmlCode, fieldLayout3);

		//------------------------------------------------------
		// ROW 08
		//------------------------------------------------------
		HorizontalLayoutContainer row08 = new HorizontalLayoutContainer();

		row08.add(new LabelToolItem("상장일자"), labelLayout1);
		row08.add(listDateConv, fieldLayout1);

		row08.add(new LabelToolItem(), termLayout1);

		row08.add(new LabelToolItem(), labelLayout2);
		row08.add(new LabelToolItem(), fieldLayout2);

		row08.add(new LabelToolItem(), termLayout2);

		row08.add(new LabelToolItem("평가구분"), labelLayout3);
		row08.add(evlTypeCode, fieldLayout3);
		
		//------------------------------------------------------
		// ROW 09
		//------------------------------------------------------
		HorizontalLayoutContainer row09 = new HorizontalLayoutContainer();

		row09.add(new LabelToolItem("결산월"), labelLayout1);
		row09.add(cloMonth, fieldLayout1);

		row09.add(new LabelToolItem(), termLayout1);

		row09.add(new LabelToolItem("과세구분"), labelLayout2);
		row09.add(taxTypeCode, fieldLayout2);

		row09.add(new LabelToolItem(), termLayout2);

		row09.add(new LabelToolItem("장부가평가방식"), labelLayout3);
		row09.add(evlFrmlCode, fieldLayout3);
		
		//------------------------------------------------------
		// ROW 10
		//------------------------------------------------------
		HorizontalLayoutContainer row10 = new HorizontalLayoutContainer();

		row10.add(new LabelToolItem("액면"), labelLayout1);
		row10.add(par, fieldLayout1);

		row10.add(new LabelToolItem(), termLayout1);

		row10.add(new LabelToolItem("과세시점구분"), labelLayout2);
		row10.add(taxPosTypeCode, fieldLayout2);

		row10.add(new LabelToolItem(), termLayout2);

		row10.add(new LabelToolItem("상환손익계산구분"), labelLayout3);
		row10.add(rdmPlCalcTypeCode, fieldLayout3);
		
		//------------------------------------------------------
		// ROW 11
		//------------------------------------------------------
		HorizontalLayoutContainer row11 = new HorizontalLayoutContainer();

		row11.add(new LabelToolItem("공모/사모"), labelLayout1);
		row11.add(pubPrvTypeCode, fieldLayout1);

		row11.add(new LabelToolItem(), termLayout1);

		row11.add(new LabelToolItem("원천징수구분"), labelLayout2);
		row11.add(whTypeCode, fieldLayout2);

		row11.add(new LabelToolItem(), termLayout2);

		row11.add(new LabelToolItem("미수이자계산방식"), labelLayout3);
		row11.add(rcvbIntCalcFrmlCode, fieldLayout3);
		
		//------------------------------------------------------
		// ROW 12
		//------------------------------------------------------
		HorizontalLayoutContainer row12 = new HorizontalLayoutContainer();

		row12.add(new LabelToolItem("거래소구분"), labelLayout1);
		row12.add(krxTypeCode, fieldLayout1);

		row12.add(new LabelToolItem(), termLayout1);

		row12.add(new LabelToolItem("해외원천징수구분"), labelLayout2);
		row12.add(abroWhTypeCode, fieldLayout2);

		row12.add(new LabelToolItem(), termLayout2);

		row12.add(new LabelToolItem("원장관리방식"), labelLayout3);
		row12.add(astMngFrmlCode, fieldLayout3);
		
		//------------------------------------------------------
		// ROW 13
		//------------------------------------------------------
		HorizontalLayoutContainer row13 = new HorizontalLayoutContainer();

		row13.add(new LabelToolItem("매매단위"), labelLayout1);
		row13.add(dealUnt, fieldLayout1);

		//------------------------------------------------------
		// ROW 14
		//------------------------------------------------------
		HorizontalLayoutContainer row14 = new HorizontalLayoutContainer();

		row14.add(new LabelToolItem(), labelLayout1);
		row14.add(new LabelToolItem(), fieldLayout1);

		row14.add(new LabelToolItem(), termLayout1);

		row14.add(new LabelToolItem("보증구분"), labelLayout2);
		row14.add(grtTypeCode, fieldLayout2);

		row14.add(new LabelToolItem(), termLayout2);

		row14.add(new LabelToolItem("발행기관"), labelLayout3);
		row14.add(issCorpCode, fieldLayout3);

		//------------------------------------------------------
		// ROW 15
		//------------------------------------------------------
		HorizontalLayoutContainer row15 = new HorizontalLayoutContainer();

		row15.add(new LabelToolItem("운용사"), labelLayout1);
		row15.add(mngCoCode, fieldLayout1);

		row15.add(new LabelToolItem(), termLayout1);

		row15.add(new LabelToolItem("보증기관"), labelLayout2);
		row15.add(grtCorpCode, fieldLayout2);

		row15.add(new LabelToolItem(), termLayout2);

		row15.add(new LabelToolItem("원발행기관"), labelLayout3);
		row15.add(orgIssCorpCode, fieldLayout3);
		
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(row01, new VerticalLayoutData(1, 30, new Margins(20,0,0,20)));
		vlc.add(row02, new VerticalLayoutData(1, 30, new Margins(25,0,0,20)));
		vlc.add(row03, new VerticalLayoutData(1, 30, new Margins(30,0,0,20)));
		vlc.add(row04, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row05, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row06, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row07, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row08, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row09, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row10, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row11, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row12, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row13, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row14, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));
		vlc.add(row15, new VerticalLayoutData(1, 30, new Margins(35,0,0,20)));

		this.add(vlc);
	}

	public void retrieve(String itmCode) {
		actionName = "retrieve";
		ServiceRequest request = new ServiceRequest("itm.Itm01_Itm.selectByItmCode");
		request.putStringParam("cmpCode", LoginUser.getCmpCode());
		request.putStringParam("itmCode", itmCode);
		
		ServiceCall service = new ServiceCall();
		service.execute(request, this);
	}

	@Override
	public void getServiceResult(ServiceResult result) {
		if("retrieve".equals(this.actionName)) {
			itmModel = (Itm01_ItmModel)result.getResult(0);
			editDriver.edit(itmModel);
		}
	}

}