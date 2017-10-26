package com.tibco.transform;

import java.util.List;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class JsonTransform {

	protected String inputJSON = "";
	protected String outputJSON = "";

	public void invoke() {
		List specJSON = JsonUtils.classpathToList("/com/tibco/transform/spec.json");
	    Chainr chainr = Chainr.fromSpec(specJSON);
	    Object oubjectJSON = JsonUtils.jsonToObject(inputJSON);
	    Object transformedOutput = chainr.transform(oubjectJSON);
	    outputJSON=JsonUtils.toJsonString(transformedOutput);
	}
	
	public static void main(String[] args) {
	//	String sample = "{\"took\":13,\"timed_out\":false,\"_shards\":{\"total\":5,\"successful\":5,\"skipped\":0,\"failed\":0},\"hits\":{\"total\":1,\"max_score\":null,\"hits\":[{\"_index\":\"products\",\"_type\":\"product\",\"_id\":\"893309\",\"_score\":null,\"_source\":{\"defaultparentCategory\":true,\"endDate\":\"12/31/9999\",\"departmentCode\":\"04\",\"consumerPurchaseChoice\":[{\"consmPrchChcDes\":\"Sold by Each\",\"consmPrchChcCd\":\"EACH\"}],\"childSku\":[4155451609],\"leb\":false,\"type\":\"GOODS\",\"taxCategoryCD\":\"000003\",\"tagItemTypCd\":\"ITMCD\",\"alcoholPct\":0,\"ownBrand\":false,\"weightTolerance\":false,\"heartHealthyClaim\":false,\"isLargeSurcharge\":false,\"foodStamp\":false,\"isAddOnProduct\":false,\"privateLabel\":false,\"upc\":4155451609,\"lowSodiumClaim\":false,\"primoPick\":false,\"orderIncrement\":1,\"pssDepartmentId\":\"32\",\"retlUntWd\":3,\"fsa\":false,\"bonusPack\":false,\"productFulfillmentChnl\":[{\"isShipToHome\":false,\"isCurbsidePickUp\":false,\"isShipToHomeFresh\":false,\"isPickUpInStore\":false,\"isDisplayOnly\":true,\"isCurbsideDelivery\":false,\"isShipToStore\":false,\"isDoNotDisplay\":false,\"isShipFromStore\":false,\"isDeliveryToHome\":false}],\"startDate\":\"01/06/2007\",\"template\":\"Other\",\"retlUntWt\":0,\"displayName\":\" ,\",\"procurementHiearchy\":[{\"budName\":\"Tracy Bliss\",\"prodCatId\":\"576\",\"budNbr\":\"810\",\"prodCatName\":\"MAKE UP\",\"bdmName\":\"HEIDI DEEN\",\"bdmCode\":\"48\"}],\"prodId\":893309,\"subdepartmentCode\":\"C\",\"wic\":false,\"tagItemId\":137807,\"showOnSite\":false,\"minAgeRestriction\":0,\"uomQty\":\"1\",\"lowSaturatedFatClaim\":false,\"classCode\":64,\"isTaxable\":true,\"maxOrderValue\":9.99999999E8,\"madeInTexas\":false,\"defaultSku\":4155451609,\"stdUomCd\":\"EACH\",\"checkDigitUpc\":\"041554516098\",\"retlUntHt\":4,\"fiberSourceClaim\":false,\"imgUri\":893309,\"plu\":false,\"ageRestriction\":false,\"isSupplement\":false,\"lastUpdatedTs\":\"2017-10-18\",\"averageWeight\":0,\"retlUntLn\":1.5,\"minOrderValue\":1},\"sort\":[893309]}]}}";
	}

	public String getInputJSON() {
			return inputJSON;
		}
	public void setInputJSON(String val) {
			inputJSON = val;
		}

	public String getOutputJSON() {
			return outputJSON;
		}
	public void setOutputJSON(String val) {
			outputJSON = val;
		}
}
