package com.tibco.transform;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.json.*;
import java.util.*;

public class Transform {
	
	protected String inputJSON = "";
	protected String index = "";
	protected String type = "";
	protected String transformJSON = "";
	protected int records = 0;
	protected String root = "";
	public String transformJSON() {
		StringWriter w = new StringWriter();
		PrintWriter wrt = new PrintWriter(w);
		try {
			JSONObject outerObject = new JSONObject(inputJSON);
			JSONArray jsonArray = (JSONArray)outerObject.get(root);
			for (int i = 0, size = jsonArray.length(); i < size; i++)
		    {
		      JSONObject objectInArray = jsonArray.getJSONObject(i);
		      String id = objectInArray.getString("prodId");
		      wrt.print("{\"index\" : { \"_index\" : \"");
		      wrt.print(index);
		      wrt.print("\", \"_type\" : \"");
		      wrt.print(type);
		      wrt.print("\", \"_id\" : \"");
		      wrt.print(id);
		      wrt.println("\" }}");
		      wrt.println(objectInArray.toString());
		      wrt.flush();
		      records++;
		    //  System.out.println(w.toString());
		    }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		wrt.print("{}");
		wrt.flush();
	    return w.toString();
	}
	
	public void invoke() {
		transformJSON = transformJSON();
	}
	
	
	public static void main(String[] arg) {
		String jsonInput  = "{\"price\":[{\"prodId\":59,\"prodGrpId\":59,\"skuId\":65006600053,\"storeId\":108,\"isAvailable\":true,\"prodLoc\":\"Front Edge of Drugstore end of the Aisle\",\"shoppingListSeq\":163100,\"onSale\":false,\"onAd\":false,\"isDeal\":false,\"mktBugId\":\"\",\"mktBugDesc\":\"\",\"listPrice\":1,\"listPriceXfor\":1,\"listWeightSw\":false,\"listPriceEffDt\":\"2016-05-24\",\"salePrice\":1,\"salePriceXfor\":1,\"saleWeightSw\":false,\"salePriceEffDt\":\"2016-05-24\",\"salePriceEndDt\":\"2017-05-24\",\"modified_ts\":\"2017-09-20\",\"aisleNbr\":1,\"aisleSideId\":\"B\",\"sectNbr\":5,\"shlfId\":6,\"alcoSw\":\"N\",\"changeTypeCd\":\"A\"}]}";
		Transform t = new Transform();
		t.transformJSON();
	}

	public String getInputJSON() {
			return inputJSON;
		}
	public void setInputJSON(String val) {
			inputJSON = val;
		}

	public String getIndex() {
			return index;
		}
	public void setIndex(String val) {
			index = val;
		}

	public String getType() {
			return type;
		}
	public void setType(String val) {
			type = val;
		}

	public String getTransformJSON() {
			return transformJSON;
		}
	public void setTransformJSON(String val) {
			transformJSON = val;
		}

	public int getRecords() {
			return records;
		}
	public void setRecords(int val) {
			records = val;
		}

	public String getRoot() {
			return root;
		}
	public void setRoot(String val) {
			root = val;
		}
}
