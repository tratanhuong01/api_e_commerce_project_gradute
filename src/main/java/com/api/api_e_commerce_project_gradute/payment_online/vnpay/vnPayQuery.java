//package com.api.api_e_commerce_project_gradute.payment_online.vnpay;
//
//public class vnPayQuery {
//  String vnp_TxnRef = req.getParameter("order_id");
//  String vnp_TransDate = req.getParameter("trans_date");
//  String vnp_TmnCode = Config.vnp_TmnCode;
//  String vnp_IpAddr = Config.getIpAddress(req);
//
//  Map<String, String> vnp_Params = new HashMap<>();
//        vnp_Params.put("vnp_Version", "2.1.0");
//        vnp_Params.put("vnp_Command", "querydr");
//        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
//        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
//        vnp_Params.put("vnp_OrderInfo", "Kiem tra ket qua GD OrderId:" + vnp_TxnRef);
//        vnp_Params.put("vnp_TransDate", vnp_TransDate);
//        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
//
//  Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
//  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
//  String vnp_CreateDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
//  //Build data to hash and querystring
//  List fieldNames = new ArrayList(vnp_Params.keySet());
//        Collections.sort(fieldNames);
//  StringBuilder hashData = new StringBuilder();
//  StringBuilder query = new StringBuilder();
//  Iterator itr = fieldNames.iterator();
//        while (itr.hasNext()) {
//    String fieldName = (String) itr.next();
//    String fieldValue = (String) vnp_Params.get(fieldName);
//    if ((fieldValue != null) && (fieldValue.length() > 0)) {
//      //Build hash data
//      hashData.append(fieldName);
//      hashData.append('=');
//      hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
//      //Build query
//      query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
//      query.append('=');
//      query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
//
//      if (itr.hasNext()) {
//        query.append('&');
//        hashData.append('&');
//      }
//    }
//  }
//  String queryUrl = query.toString();
//  String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret, hashData.toString());
//  queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
//  String paymentUrl = Config.vnp_apiUrl + "?" + queryUrl;
//  URL url = new URL(paymentUrl);
//  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//  BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//  String inputLine;
//  StringBuilder response = new StringBuilder();
//
//        while ((inputLine = in.readLine()) != null) {
//    response.append(inputLine);
//  }
//        in.close();
//  String Rsp = response.toString();
//  String respDecode = URLDecoder.decode(Rsp, "UTF-8");
//  String[] responseData = respDecode.split("&|\\=");
//  com.google.gson.JsonObject job = new JsonObject();
//        job.addProperty("data", Arrays.toString(responseData));
//  Gson gson = new Gson();
//        resp.getWriter().write(gson.toJson(job));
//}
