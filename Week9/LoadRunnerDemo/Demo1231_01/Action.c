Action()
{

	web_set_sockets_option("SSL_VERSION", "AUTO");

	web_url("generate_204", 
		"URL=http://connectivitycheck.gstatic.com/generate_204", 
		"Resource=0", 
		"Referer=", 
		"Snapshot=t1.inf", 
		"Mode=HTML", 
		LAST);

	web_custom_request("v1:GetModels", 
		"URL=https://optimizationguide-pa.googleapis.com/v1:GetModels?key=AIzaSyA2KlwBX3mkFo30om9LUFYQhpqLoa_BNhE", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/x-protobuf", 
		"Referer=", 
		"Snapshot=t2.inf", 
		"Mode=HTML", 
		"EncType=application/x-protobuf", 
		"BodyBinary=\n\n\\x08\\x02\\x10\\xC6\\xB2\\xE1\\xA0\\x06 \\x15\nt\\x08\t\\x10\\x8B\\xB8\\x9D\\xC0\\x06 \\x152h\natype.googleapis.com/google.privacy.webpermissionpredictions.v1.WebPermissionPredictionsClientInfo\\x12\\x03\\x08\\x8F\\x01\n\n\\x08\r\\x10\\xF1\\xE9\\x9C\\x9E\\x06 \\x15\ng\\x08\\x0F\\x10\\x05 \\x152_\nWtype.googleapis.com/google.internal.chrome.optimizationguide.v1.PageTopicsModelMetadata\\x12\\x04\\x08\\x020\\x02\ng\\x08\\x10 \\x152a\nYtype.googleapis.com/"
		"google.internal.chrome.optimizationguide.v1.SegmentationModelMetadata\\x12\\x04J\\x02\\x10\\x03\nt\\x08\\x14\\x10\\xEB\\xAC\\x9D\\xC0\\x06 \\x152h\natype.googleapis.com/google.privacy.webpermissionpredictions.v1.WebPermissionPredictionsClientInfo\\x12\\x03\\x08\\x8F\\x01\ng\\x08\\x15 \\x152a\nYtype.googleapis.com/google.internal.chrome.optimizationguide.v1.SegmentationModelMetadata\\x12\\x04J\\x02\\x10\\x03\ng\\x08\\x17 \\x152a\nYtype.googleapis.com/"
		"google.internal.chrome.optimizationguide.v1.SegmentationModelMetadata\\x12\\x04J\\x02\\x10\\x03\n\n\\x08\\x18\\x10\\xF4\\xC3\\x90\\xB8\\x06 \\x15\n\n\\x08\\x19\\x10\\xE4\\xB7\\x83\\xC8\\x06 \\x15\nr\\x08\\x1A\\x10\\xA6\\x80\\xEC\\xA8\\x06 \\x152f\n`type.googleapis.com/google.internal.chrome.optimizationguide.v1.AutocompleteScoringModelMetadata\\x12\\x02\\x10\\x02\ng\\x08\\x1B \\x152a\nYtype.googleapis.com/"
		"google.internal.chrome.optimizationguide.v1.SegmentationModelMetadata\\x12\\x04J\\x02\\x10\\x03\n\n\\x08+\\x10\\xE1\\xBA\\xF1\\xBE\\x06 \\x15\nn\\x08-\\x10\\x9B\\xE2\\xC0\\xE5\\x80\\x07 \\x152a\nYtype.googleapis.com/google.internal.chrome.optimizationguide.v1.SegmentationModelMetadata\\x12\\x04J\\x02\\x10\\x03\ng\\x08. \\x152a\nYtype.googleapis.com/google.internal.chrome.optimizationguide.v1.SegmentationModelMetadata\\x12\\x04J\\x02\\x10\\x03\n\n\\x08A\\x10\\xAA\\xA0\\x9B\\xC5\\x06 \\x15\n\n"
		"\\x08B\\x10\\xF8\\xD1\\x9C\\xC5\\x06 \\x15\\x18\\x06*\\x05en-US2\\x02\\x08\\x06", 
		LAST);

	web_add_cookie("_ga_56EMNRF2S2=GS2.2.s1767196444$o1$g1$t1767196472$j32$l0$h0; DOMAIN=advantageonlineshopping.com");

	web_add_cookie("_ga_56EMNRF2S2=GS2.2.s1767196444$o1$g1$t1767196480$j24$l0$h0; DOMAIN=advantageonlineshopping.com");

	web_url("advantageonlineshopping.com", 
		"URL=https://advantageonlineshopping.com/", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=", 
		"Snapshot=t3.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=/main.min.js", ENDITEM, 
		"Url=/services.properties", ENDITEM, 
		"Url=https://www.google-analytics.com/analytics.js", ENDITEM, 
		"Url=/css/images/logo.png", ENDITEM, 
		"Url=/css/images/closeDark.png", ENDITEM, 
		"Url=/css/images/favicon.ico", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=mice", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=headphones", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=laptops", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=tablets", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=speakers", ENDITEM, 
		"Url=/css/images/Special-offer.jpg", ENDITEM, 
		"Url=/css/images/facebook.png", ENDITEM, 
		"Url=/css/images/GoUp.png", ENDITEM, 
		"Url=/css/images/twitter.png", ENDITEM, 
		"Url=/css/images/linkedin.png", ENDITEM, 
		"Url=/css/images/Banner1.jpg", ENDITEM, 
		"Url=/css/images/Banner2.jpg", ENDITEM, 
		"Url=/css/images/Popular-item3.jpg", ENDITEM, 
		"Url=/css/images/Banner3.jpg", ENDITEM, 
		"Url=/css/images/Popular-item1.jpg", ENDITEM, 
		"Url=/css/images/Popular-item2.jpg", ENDITEM, 
		"Url=/css/images/category_banner_4.png", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4300", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4600", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4700", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4200", ENDITEM, 
		"Url=/css/images/Filter.png", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4400", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4100", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4500", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4602", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4603", ENDITEM, 
		"Url=/catalog/fetchImage?image_id=4601", ENDITEM, 
		LAST);

	web_add_cookie("AKA_A2=A; DOMAIN=sstats.adobe.com");

	web_add_cookie("kndctr_9E1005A551ED61CA0A490D45_AdobeOrg_identity=CiY4NjE1NTQxMzAxNTIyMTUzNjQ2NDU4NjQ5ODY4OTIzNDQ2MzU3OVISCJSroqO3MhABGAEqA09SMjAA8AHt%2DMCntzM%3D; DOMAIN=sstats.adobe.com");

	web_custom_request("interact", 
		"URL=https://sstats.adobe.com/ee/v1/interact?configId=716bebe9-4dd6-40c2-a723-7942f40515e4", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t4.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"events\":[{\"xdm\":{\"eventType\":\"web.webpagedetails.pageViews\",\"timestamp\":\"2025-12-31T15:53:00.505Z\",\"web\":{\"webPageDetails\":{\"name\":\"DCBrowserExt:Extension:Startup:Op\",\"URL\":\"chrome-extension://efaidnbmnnnibpcajpcglclefindmkaj/\",\"siteSection\":\"Acrobat Extension\",\"server\":\"www.adobe.com\",\"isErrorPage\":false,\"isHomePage\":false,\"pageViews\":{\"value\":1}},\"webReferrer\":{\"URL\":\"\"}},\"_experience\":{\"analytics\":{\"customDimensions\":{\"eVars\":{\""
		"eVar1\":\"25.12.1.2:update\",\"eVar4\":\"unknown\",\"eVar22\":\"win\",\"eVar31\":\"ownership-install\",\"evar44\":\"d70b4618-fdde-4266-896b-16b507e6c9d2\",\"evar45\":\"false\",\"evar46\":\"VanillaFAB\",\"eVar50\":\"Viewer\",\"evar60\":\"sideload\",\"eVar80\":\"ExternalUser\",\"evar153\":\"prod\",\"evar49\":\"LFA_OFF\",\"evar24\":\"enabled\",\"evar6\":\"CLP_EGM_EMP_EON_GCIC_GCP_LFS\"},\"props\":{}}}}},\"meta\":{\"state\":{\"cookiesEnabled\":true,\"domain\":\"adobe.com\"}}}],\"query\":{\"identity\":"
		"{\"fetch\":[\"ECID\"]}}}", 
		LAST);

	web_custom_request("acquire", 
		"URL=https://sstats.adobe.com/ee/irl1/v1/identity/acquire?configId=716bebe9-4dd6-40c2-a723-7942f40515e4", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t5.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"query\":{\"identity\":{\"fetch\":[\"ECID\"]}}}", 
		LAST);

	web_custom_request("v2", 
		"URL=https://clientservices.googleapis.com/uma/v2", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=", 
		"Snapshot=t6.inf", 
		"ContentEncoding=gzip", 
		"Mode=HTML", 
		"EncType=application/vnd.chrome.uma", 
		"BodyBinary=\t!\\xB9\\xC0\\x11\\xB4l2\\xB8\\x10\\xFF\\x07\\x1A\\xBA\\x1F\\x08\\xEA\\xF7\\x8C\\xCA\\x06\\x12\\x11143.0.7499.170-64\\x18\\xB0\\xC6\\xAC\\xB7\\x06\"\\x05en-US*\\x18\n\nWindows NT\\x12\n10.0.190452\\xE5\\x02\n\\x06x86_64\\x10\\xC9\\xFF\\x01\\x18\\x80\\x80\\xA4\\xEC\\xCC\\xFF\\x1F\"\\x13Z370 AORUS Gaming 3(\\x020\\x80\\x0F8\\xB8\\x08B\\x8D\\x01\\x08\\xDE!\\x10\\x82Q\\x1A\\x0C32.0.15.91592\\x14Google Inc. (NVIDIA):aANGLE (NVIDIA, NVIDIA GeForce RTX 4060 (0x00002882) Direct3D11 vs_5_0 "
		"ps_5_0, D3D11-32.0.15.9159)M\\x95q&CU*A&Ce\\x00\\x00\\x80?j\\x18\n\\x0CGenuineIntel\\x10\\xEA\\x8D$\\x18\\x0C \\x01(\\x00\\x82\\x01\\x02\\x08\\x00\\x8A\\x01\\x02\\x08\\x00\\xAA\\x01\\x06x86_64\\xB0\\x01\\x01\\xCA\\x01b\n\\x1DGigabyte Technology Co., Ltd.\\x12\\x13Z370 AORUS Gaming 3\\x1A\\x18American Megatrends Inc.\"\\x10ALASKA - 1072009(\\x01J\n\r\\xC4_hm\\x15J\\xD4\\x8A\\x02J\n\r,\\xC3\\xA5-\\x15\\x80\\x8D}\\xCAJ\n\r\\xB1\\x83\\x11z\\x15Z\\xE5{7J\n\r\\xED\\x1B\\x1C\\xCE\\x15Z\\xE5{7J\n\r"
		"\\xC6\\xF9\\xABf\\x15Z\\xE5{7J\n\r\\x98v\\xCF&\\x15\\xC7\\x92\\xDCnJ\n\r?\\x1C\\xAE\\xD7\\x15Z\\xE5{7J\n\r\\x11\\xD6o\\xA6\\x15\\xC7\\x92\\xDCnJ\n\r\\x84\\xD3\\xEC\r\\x15\\x80\\x8D}\\xCAJ\n\r\\x00\\x08\\x1C*\\x15Z\\xE5{7J\n\rl)*\\xDE\\x15\\x0C\\xE4\\xE3\\xEEJ\n\r\\x88s\\xBA\\xA6\\x15\\x80\\x8D}\\xCAJ\n\r\\xBAV`\\xFF\\x15\\x80\\x8D}\\xCAJ\n\rk\\x05\\xF5\\xBF\\x15\\x80\\x8D}\\xCAJ\n\r\\x94DM\\x1C\\x15\\xEA\\x1D=\\xF2J\n\r\\xC0?\\xC0\t\\x15Z\\xE5{7J\n\r\\x14\\xFE\\x82\\x83\\x15Z\\xE5{7J\n\r"
		"X\\xE1\\xEA\\x9F\\x15\\x80\\x8D}\\xCAJ\n\r\\xC8i\\x8C\\x14\\x15\\x80\\x8D}\\xCAJ\n\r\\x10\\x0C\\xF8\\x08\\x15\\x93I\\x17;J\n\r.\\x05,\\xA6\\x15\\x80\\x8D}\\xCAJ\n\r\\xC4\\xB1Pu\\x15\\x80\\x8D}\\xCAJ\n\r\\x95\\xAA\\x950\\x15\\xDF\\x17J?J\n\r\\xC2h\\x8D3\\x15,\\xAC\\x06\\xC3J\n\r\\xB4i\\xD3\\xB3\\x15,\\xAC\\x06\\xC3J\n\r\\xCA\\xF8K\\x04\\x15,\\xAC\\x06\\xC3J\n\r|h\\xD8\\xE6\\x15,\\xAC\\x06\\xC3J\n\r\\xD8 \\xA3\\xDE\\x15,\\xAC\\x06\\xC3J\n\r0V\\xD5[\\x15\\xA7_\\xF2XJ\n\r\\xA2\\x80\\x86p\\x15,"
		"\\xAC\\x06\\xC3J\n\r\\x99\\xDB\\xC2\\xAF\\x15,\\xAC\\x06\\xC3J\n\rr!\\x98<\\x15,\\xAC\\x06\\xC3J\n\r\\xE7\\x8C$\\x8F\\x15,\\xAC\\x06\\xC3J\n\r\\x94\\xCCN\\xAD\\x15\\xA7_\\xF2XJ\n\rx\\xC5\\xFF\\x08\\x15,\\xAC\\x06\\xC3J\n\r\\x99\\xCC\\x07\\x95\\x15\\xA5\\xEB\\xC33J\n\r\\x81\\xCF)\\x97\\x15\\xAB7\\x13\\x80J\n\r`\\xDCqK\\x15\\xA5\\xEB\\xC33J\n\r\\x9F|\\x0CK\\x15Z\\xE5{7J\n\rUY\\xE0\\x1A\\x15\\x82KT3J\n\r\\xB9\\xF5\\x14\\xF3\\x15T\\xB2\\xEA\\xDCJ\n\r\\xD8\\xEA0\\x0E\\x15G\\xCF/!J\n\r"
		"\\x9EZY\\x95\\x15\\xFB\\x12.wJ\n\r/\\x8C\\xCE\\xED\\x15Z\\xE5{7J\n\ri\\x0E\\x9C\\x99\\x15\\x80\\x8D}\\xCAJ\n\rV\\xAF\\xA4\\xF5\\x15g\\xE7\\xEAXJ\n\rD^\\x8AW\\x15\\x80\\x8D}\\xCAJ\n\rC\\x83\\x15\\xE7\\x15\\x80\\x8D}\\xCAJ\n\r\\xDE\\x90\\x17\\xFC\\x15\\x80\\x8D}\\xCAJ\n\ry\\x87v\\xFB\\x15\\x80\\x8D}\\xCAJ\n\r\\xC9\\x06\\xC15\\x15\\x80\\x8D}\\xCAJ\n\r\\xB1\"\\x8F\\x94\\x15\\xB8m]bJ\n\rB\\xC5\\xF5\\xF6\\x15\\x80\\x8D}\\xCAJ\n\r\\x93\\xBEy7\\x15\\x80\\x8D}\\xCAJ\n\r\\x07[x\\xDE\\x15Z\\xE5{7J\n\r"
		"\\x06@\\x9C}\\x15\\xEB\\x14\\xA7\\xBAJ\n\r\\xD7\\x99\\xAF&\\x15\\x80\\x8D}\\xCAJ\n\re.+\\xF3\\x15\\x80\\x8D}\\xCAJ\n\r\\xB8\\xA1\\x82\\xA5\\x15=\\xF4\\xD3ZJ\n\rp\\xD1m\\xBD\\x15\\x80\\x8D}\\xCAJ\n\r\\xC8\\x99\\xF4h\\x15\\x80\\x8D}\\xCAJ\n\r\\xFD\\x8F1\\x0B\\x15\\x80\\x8D}\\xCAJ\n\r\\x92\\\\5n\\x15,\\xD5\\xA9\\x05J\n\r5\\xBCd\\x01\\x15Z\\xE5{7J\n\r\\x8D\\xCD^\\x9D\\x15O\\x9B/\\xD1J\n\r\\xAE$7\\xEB\\x15Z\\xE5{7J\n\r+6\\xB0\\xE3\\x15\\xC3\\xB6\\x10\\xC5J\n\r\\x97\\xE2t\\xA3\\x15\r\\xE4\\x8BwJ\n\r"
		"0\\xF0A\\xAF\\x15Z\\xE5{7J\n\r\\x00\\x92Z{\\x15\\x80\\x8D}\\xCAJ\n\r\\x81t4?\\x15J\\xD4\\x8A\\x02J\n\r\\xB1\\\\\\xD5\\x8D\\x15Z\\xE5{7J\n\r\\xCB\\xD6K\\xB9\\x15\\x037\\xA4\\xF9J\n\r\\x87\\xCE\\x00\\xD5\\x15Z\\xE5{7J\n\r\\x13\\xC7\\xF6\\x9C\\x15\\x80\\x8D}\\xCAJ\n\r\\xE1k\\x94\"\\x15\\xDB0\\xD4*J\n\r\\x01$\\xCF\n\\x15\\x0B7\\xDE\\xF5J\n\rm#:^\\x15d\\xC4;`J\n\r\\x9E>%\\x0E\\x15\\x80\\x8D}\\xCAJ\n\rnn\\x04\\xC9\\x15\\x80\\x8D}\\xCAJ\n\r\\xBE\\x9B\\xF7o\\x15\\x80\\x8D}\\xCAJ\n\r"
		"%_\\xC6\\x99\\x15\\x80\\x8D}\\xCAJ\n\rHx\\xBET\\x158\\xCD\\xB6\\xFFJ\n\r\\xCD\\x86\\xFD\\x86\\x15\\x037\\xA4\\xF9J\n\r\\xFFL\\xC8\\x81\\x15\\x80\\x8D}\\xCAJ\n\r\\x0C\\xEF\\x8F\\x06\\x15Z\\xE5{7J\n\rQ\\x8Cml\\x152\\xE5ITJ\n\r\\x88I\\xDF\\xFF\\x15\\x80\\x8D}\\xCAJ\n\r\\x0F\\x16I\\xD6\\x15\\x80\\x8D}\\xCAJ\n\r\\x92\\x84\\xDE\\x8C\\x15\\x80\\x8D}\\xCAJ\n\r\\xB9\\xFC\\xC9:\\x15\\xEB\\x14\\xA7\\xBAJ\n\r\\x04\\x8BA\\x8F\\x15\\xFFK\\x16oJ\n\r\\xEA\\xEE\\xC1r\\x15I\\xDD\\xD5\\xE4J\n\r\\xFE&"
		"\\xDA\\xF1\\x15Xl\\x04\\xCDJ\n\r\"L}\\xE4\\x15\\x80\\x8D}\\xCAJ\n\r\\xFEC\\xB1\\xBC\\x15D\\xD0\\x9C\\x02J\n\r\\x8D\\xFFc\\xF5\\x15\\x80\\x8D}\\xCAJ\n\r\\xE5\\xAE\\xC3\\xEA\\x15\\x80\\x8D}\\xCAJ\n\r:\\x90\\xAC\\x1A\\x15\\x80\\x8D}\\xCAJ\n\r\\x18\\xD7\\x8C\\x95\\x15\\x80\\x8D}\\xCAJ\n\r\\x16\\x0B\\x04\\xBE\\x15\\x037\\xA4\\xF9J\n\rW\\x03\\xDDp\\x15\\x80\\x8D}\\xCAJ\n\rPF\\x0E|\\x15\\x80\\x8D}\\xCAJ\n\rkK\\x95\\xD5\\x15Z\\xE5{7J\n\r\\xF4\\xEF\\x90\\xA8\\x15Z\\xE5{7J\n\rn<Y\\x19\\x15Z\\xE5{7J\n\r"
		"\\xAEWl\\xB5\\x15?\\x80\\x9D\\xA7J\n\r\\x1A\\x11\\xF6\\xC8\\x15\\x80\\x8D}\\xCAJ\n\r\\x1D)\\xB6\\xF3\\x15W\\x19\\xA2\\x12J\n\rz\\xF3F\\xBF\\x15\\x80\\x8D}\\xCAJ\n\r6\\x10\\xE8\\xDB\\x15\\x80\\x8D}\\xCAJ\n\r\\x86pi\\x08\\x15\\x80\\x8D}\\xCAJ\n\r2\\xB7x\\\\\\x15\\x80\\x8D}\\xCAJ\n\rq_:\\x9D\\x15\\x80\\x8D}\\xCAJ\n\r\\xF4\\xDD\\xDC\\x1E\\x15\\xD5\\x13\\x9DeJ\n\rQ\\xC0|[\\x15Z\\xE5{7J\n\r\\xE6E\\xFA\\xD0\\x15\\xF9\\x1BR\\x05J\n\r\\xDB\\x9C\\x8B\\xFF\\x15\\x80\\x8D}\\xCAJ\n\rJr{y\\x15\\x037\\xA4\\xF9J"
		"\n\r\\xE7M\\xC6S\\x15\\x80\\x8D}\\xCAJ\n\r\\x0B\\xD0F\\xC0\\x15\\x80\\x8D}\\xCAJ\n\r3Y\\x06X\\x15\\xDF\\x17J?J\n\r\\xF0\\xFDt\\xA3\\x15\\xF6\\xE3\\x16\\x14J\n\r\\xB3%CL\\x15\\x8B\\xDC\\x1C\\xA2J\n\r\\xE0c\\x86\\\\\\x15Z\\xE5{7J\n\r*\\x9D\\xFAS\\x15~\\xFE\\x88KJ\n\r\\xEA|\\x8D\\x9C\\x15\\x80\\x8D}\\xCAJ\n\rUg\\xAD\\xFD\\x15\\x80\\x8D}\\xCAJ\n\r\\x07\\xD9m\\xC9\\x15op\\x17\\x84J\n\r!\\xB9\\x03\\xCB\\x15Z\\xE5{7J\n\r\\x80\\xDAe\\x14\\x15([\\x9BoJ\n\r\\xE5\\xB6z\\xBE\\x15\\x037\\xA4\\xF9J\n\r"
		"A\\xA6\\xD2\\xE2\\x15\\xCA\\xA2\\xD7\\xB8J\n\r2!\\x180\\x15\\x80\\x8D}\\xCAJ\n\r\\x1E\\x08\\xE0-\\x15\\x80\\x8D}\\xCAJ\n\r\"}\\xAA\\xC3\\x15\\x80\\x8D}\\xCAJ\n\r`\\x87MI\\x15C]2RJ\n\rU\\x08\\xC6:\\x15\\x9C*nHJ\n\r\\xA3\\xB6\\xDCc\\x15\\xCB2\\x99\\xC0J\n\rF\\xE7\\x06\\xE7\\x15W\\xBB\\xC2OJ\n\r\\x0C\\x19\\x96\\xF2\\x15-\\xA3\\x82\\x82J\n\r\\xE2\\xAABD\\x15\\x1EgXqJ\n\rd\\xCF\\x90\\xF6\\x15c(\\x82\\xA5J\n\rw\\xD3\\xD1\\x0E\\x15\\x14\\x0F\\xCC\\xE1J\n\r\\xA0\\xF0\\xF0u\\x15<\\xB1\\xF6\\xD7J\n\r\\x90?"
		"\\x0Cq\\x15\\xE7\\xFF\\xDFkJ\n\r\\x81\\x84\\xB1\\xE2\\x15\\xDE~YnJ\n\r\\x89\\x18\\xE7\\xE7\\x15u\\x05\\xD6JJ\n\r\\xACq\\x82:\\x15\\x1C\\x13\\x9E\\x0EJ\n\r\\xEBt\\x95\\xA3\\x15\\x03\\xC5r\\xCAJ\n\r\\xDEQ\\xB7r\\x15\\x80\\x8D}\\xCAJ\n\r\\xB7\\xDE\\x8F\\xCE\\x15\\xEA\\x1D=\\xF2J\n\rn\\xE4\\x07\\x1B\\x15#U6NJ\n\r\\xC2\\xA9\\xA4\\xBE\\x15\\x80\\x8D}\\xCAJ\n\r\\xC2Fb/\\x15\\x80\\x8D}\\xCAJ\n\r\\x108\\x93\\xE1\\x15\\x1C\\xD1\\xE4\\xBCJ\n\r\\xEA\\x04\\x82\\xAA\\x15\\x80\\x8D}\\xCAJ\n\r"
		"g\\xC5..\\x15\\x80\\x8D}\\xCAJ\n\r#\\xC9\\xD4\\x95\\x15\\x1D\\x9C,\\xA2J\n\r\\xEA\\x91T\\xC5\\x155Z\\xFBfJ\n\r\\x12\\xB3u\\xAF\\x15Z\\xE5{7J\n\r\"\\xCB(n\\x15\\x80\\x8D}\\xCAJ\n\r\\x92\\xB7W\\xB3\\x150\\xAE\\xF2\\xDCJ\n\r\\x05\\x0E\\xF0\\xF4\\x15\\x80\\x8D}\\xCAJ\n\r\\x98\\xCE\\x81\\x94\\x15\\xDF\\x17J?J\n\r\\x03lB*\\x15\\xF4\\xF4G=J\n\r\\x98\\xF6\\x83\\xA9\\x15@z\\xC0=J\n\r\\x18\\x85gp\\x15njo J\n\r4\\x873\\xBE\\x15n\\xEFfHJ\n\r\\xA9\\x07\\x99_\\x15njo J\n\r\\x9A\\xCB\\xEC\\x8E\\x15\\x90\t"
		"0\\xFCJ\n\r\\x83VF+\\x15njo J\n\r&y\\xFCR\\x15_\\x8F\\x0EpJ\n\r\\x1D6\\x9B\\xBC\\x15\\xA8o\\xE6\\xDEJ\n\r\\x88q\\x1A\\xA4\\x15\\xFB\\xAF\\xCFBJ\n\r\\xDC\\xBFq\\xFF\\x15\\xA8o\\xE6\\xDEJ\n\r\\x0C\\xDDY!\\x15\\xD4\\x04\\x96\\x8EJ\n\r\\xD5y\\xCC\\xE7\\x15\\xA8o\\xE6\\xDEJ\n\rEU\\x93K\\x15\\xF4\\xF4G=J\n\r\\xE3\\xBA8\\x9A\\x15\\xA7\\xC8F`J\n\r\\xE1\\x04\\xADA\\x15@_\\x06\\xE4J\n\r\\xA3C\\x1E-\\x15\\xF4\\xF4G=J\n\r\\x14\\xCE\n7\\x15\\xDF\\x17J?J\n\rg\\xC2m8\\x15\\xF4\\xF4G=J\n\r\\xEE="
		"\\xD9\\xF1\\x15\\x80\\x8D}\\xCAJ\n\r5k@\\xA4\\x15\\xD6\\xE2W\\x16J\n\rF\\xA1\\x8D@\\x15\\xD6\\xE2W\\x16J\n\r}\\x96\\x9D\\xD6\\x15.\\xC9\\x956J\n\r\\xA1u\\x8F<\\x15\\xA5@\\xF8\\xA6P\\x04ZJ\\x08\\x01\\x10\\xB6\\xC0\\xC5\\xB1\\x06\\x18\\xC7\\xC0\\xC5\\xB1\\x06\"\\x1A\n\\x0C144.0.7547.0\\x10\\xE1\\xA9\\xC4\\xB1\\x06\\x18\\x00 \\x00(\\x00*\\x1E\n\\x0E143.0.7499.170\\x10\\xC7\\xC0\\xC5\\xB1\\x06\\x18\\x00 \\x1E"
		"(\\x80\\x80\\x0Cb\\x04GGLSj\\x08\\x08\\x00\\x10\\x018\\x06@\\x06\\x80\\x01\\xB0\\xF2\\xC1\\xD5\\x05\\x90\\x01T\\x90\\x01\\x99\\x01\\x90\\x01\\xA9\\x01\\x90\\x01\\xBF\\x01\\x90\\x01\\xDD\\x02\\x90\\x01\\xEB\\x02\\x90\\x01\\xA1\\x03\\x90\\x01\\xC8\\x03\\x90\\x01\\xB3\\x04\\x90\\x01\\xFB\\x05\\x90\\x01\\x88\\x07\\x90\\x01\\xD7\\x07\\x90\\x01\\xF9\\x07\\x98\\x01\\x01\\xB0\\x01\\x01\\xBA\\x01\\x0C\\x15i\\x04u~%\\x00\\x00\\x00\\x00(\\x00\\xC2\\x01\\x1C\\x08#\\x12\\x0E2023.3.30.1305\\x1D\\x15E8+"
		"%\\x9D\\xD6\\xB6\\xB7\\xC2\\x01\\x1D\\x08!\\x12\\x0F2025.6.13.84507\\x1D\\x00\\x00\\x00\\x00%\\xD3\"Ac\\xC2\\x01\\x12\\x080\\x12\\x041537\\x1D\\x00\\x00\\x00\\x00%\\x86\\xB3\\xD8|\\xC2\\x01\\x14\\x08\\x0B\\x12\\x069.64.0\\x1D\\x00\\x00\\x00\\x00%\\xA8\\xB4eo\\xC2\\x01\\x1C\\x08\\x1F\\x12\\x0E2025.12.29.121\\x1D\\x00\\x00\\x00\\x00%\\xFC/\\x00\\x8E\\xC2\\x01\\x0F\\x08\\x08\\x12\\x017\\x1Dlm\\xB1>%;\\xCAI\\x1C\\xC2\\x01\\x19\\x08(\\x12\\x0B2025.7.24.0\\x1D\\x00\\x00\\x00\\x00%\t"
		"cq\\xBF\\xC2\\x01\\x0F\\x08B\\x12\\x014\\x1D\\x00\\x00\\x00\\x00%\\xB6\\x9F\\xB0\\xE0\\xC2\\x01\\x13\\x08\n\\x12\\x0510251\\x1D\\x00\\x00\\x00\\x00%\\xA4\\x07\\xC7b\\xC2\\x01\\x18\\x082\\x12\n1.3.36.141\\x1DF\\xB2\\xED\\xAE%\\xDB\\xED\\xA0\\x00\\xC2\\x01\\x1A\\x08)\\x12\\x0C120.0.6050.0\\x1D\\xA7b,\\xC5%|?'Y\\xC2\\x01\\x19\\x08?"
		"\\x12\\x0B2025.10.7.1\\x1D\\x00\\x00\\x00\\x00%\\x99K\\xD8\\xA8\\xC2\\x01\\x12\\x083\\x12\\x043089\\x1D\\x00\\x00\\x00\\x00%o5\\xC7\\xF4\\xC2\\x01\\x1A\\x08\\x02\\x12\\x0C145.0.7584.0\\x1D\\x00\\x00\\x00\\x00%U\\xF4\\xBF\\xFA\\xC2\\x01\\x19\\x08>\\x12\\x0B2025.9.29.1\\x1D\\x00\\x00\\x00\\x00%v8\\x8D\\xE6\\xC2\\x01\\x1E\\x08/"
		"\\x12\\x101.0.7.1744928549\\x1D`\\xBAD\\xE4%\\x82\\xBB\\xB5\\xF5\\xC2\\x01\\x16\\x08\\x03\\x12\\x081.0.0.19\\x1D\\x00\\x00\\x00\\x00%\\xDB\\xED\\xA0\\x00\\xC2\\x01\\x11\\x08\\x12\\x12\\x03597\\x1D\\x00\\x00\\x00\\x00%\\x11\\xAB\\x10\\xFB\\xC2\\x01\\x18\\x08\\x1E\\x12\n1.0.2738.0\\x1D\\x9A\\xBA\\x00\\xC9%[\\x842\\x16\\xC2\\x01#\\x08\\x19\\x12\\x1520251020.824019708.14\\x1D\\x00\\x00\\x00\\x00%\\xBE.\\x05%\\xC2\\x01\\x19\\x08\r"
		"\\x12\\x0B4.10.2934.0\\x1D\\x00\\x00\\x00\\x00%\\xD4\\x16\\xCE\\x02\\xC2\\x01\\x0F\\x08\\x1B\\x12\\x013\\x1D\\xA4fVT%\\xE3\\xCA4\\xB6\\xCA\\x01 \\x08\\x04\\x10\\x05\\x18\\x01 \\x00(\\x000\\x008\\x00@\\x00P\\x00X\\x00`\\x00h\\x00x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01$\\x08\\x01\\x10\\x01\\x18\\x02 \\x01(\\x000\\x008\\x01@\\x01P\\x00X\\x00`\\x00h\\x01p\\x00p\\x01x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x01\\x10\\x01\\x18\\x03 \\x04"
		"(\\x000\\x018\\x01@\\x01P\\x00X\\x00`\\x00h\\x03x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x01\\x10\\x06\\x18\\x03 \\x04(\\x000\\x008\\x01@\\x01P\\x00X\\x00`\\x00h\\x03x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x01\\x10\\x05\\x18\\x03 \\x00(\\x000\\x008\\x00@\\x00P\\x00X\\x00`\\x00h\\x03x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x04\\x10\\x01\\x18\\x02 \\x00(\\x000\\x008\\x01@\\x01P\\x00X\\x00`\\x00h\\x00x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 "
		"\\x08\\x01\\x10\\x06\\x18\\x03 \\x00(\\x000\\x008\\x01@\\x01P\\x00X\\x01`\\x00h\\x03x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x04\\x10\\x01\\x18\\x02 \\x00(\\x000\\x008\\x01@\\x01P\\x00X\\x00`\\x00h\\x00x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x01\\x10\\x05\\x18\\x02 \\x00(\\x000\\x008\\x00@\\x00P\\x00X\\x00`\\x00h\\x00x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x04\\x10\\x01\\x18\\x02 \\x00"
		"(\\x000\\x008\\x01@\\x01P\\x00X\\x00`\\x00h\\x00x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x01\\x10\\x05\\x18\\x02 \\x00(\\x000\\x008\\x00@\\x00P\\x00X\\x00`\\x00h\\x02x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x06\\x10\n\\x18\\x02 \\x00(\\x000\\x008\\x01@\\x01P\\x00X\\x01`\\x00h\\x02x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xCA\\x01 \\x08\\x06\\x10\\x01\\x18\\x02 \\x00"
		"(\\x000\\x008\\x01@\\x01P\\x00X\\x00`\\x00h\\x02x\\x00\\x80\\x01\\x00\\x88\\x01\\x00\\xE2\\x01\\x1620251219-070015.367000\\xF8\\x01\\xC8\\x1D\\x80\\x02\\xFF\\xFF\\xFF\\xFF\\xFF\\xFF\\xFF\\xFF\\xFF\\x01\\x88\\x02\\x01\\x92\\x02$f5a92582-8085-47c8-bb3e-7c4ccf8e7687\\xA8\\x02\\xE5\\x15\\xB2\\x02\\x04\\x04%\\x80\\xFB\\xBA\\x02\\x0E\\x08\\xB0\\xC6\\xAC\\xB7\\x06\\x18\\xB0\\xC6\\xAC\\xB7\\x06 \\x01\\xF1\\x02\\xF9\\x98\\xCB?@n\\x87\\x9E\\x8A\\x03\\x03\n\\x01\\x002\r\tVM\\xC4\\xD3\\xE0\\x1D],"
		"\\x1A\\x02\\x10\\x012\\x0F\t_\\xFC\\xBB9\\xAF\\x97\\xD3\\x9A\\x10\\x01\\x1A\\x02\\x10\\x022\\x11\t\\x17\\xF9\\xCB\\xEA\\x16s\\xCD\\x8C\\x10\\x84\\x07\\x1A\\x03\\x10\\x85\\x07\\xE0\\x01\\xFD\\x0B\\xE8\\x01\\xB7\\x0F", 
		LAST);

	web_custom_request("json", 
		"URL=https://update.googleapis.com/service/update2/json?cup2key=15:3sp33kibNkjnbA6J4EnXveCSRMYGm6z0wuIThnK3ovk&cup2hreq=e473c8cab82fb871d971b5c30cd8d0d54ed6ec8f20925b2636b2b39136d322b5", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t7.inf", 
		"Mode=HTML", 
		"EncType=application/json", 
		"Body={\"request\":{\"@os\":\"win\",\"@updater\":\"chrome\",\"acceptformat\":\"crx3,download,puff,run,xz,zucc\",\"apps\":[{\"appid\":\"ihnlcenocehgdaegdmhbidjhnhdchfmm\",\"brand\":\"GGLS\",\"cohort\":\"1::\",\"cohorthint\":\"Win (Including up-to-date)\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{f35956f0-3589-4c3f-bd79-c7ad7fa652c5}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"1.3.36.141\"},{\"appid\":\"neifaoindggfcjicffkgpmnlppeffabd\",\"brand\":\"GGLS\",\"cohort\":\"1"
		":1299:\",\"cohorthint\":\"Windows (102+, canary/dev/beta/stable)\",\"cohortname\":\"Auto\",\"enabled\":true,\"installdate\":5862,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{b8c59401-a32e-4444-9a15-e762fe2cac62}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"1.0.2738.0\"},{\"appid\":\"oimompecagnajdejgnnjijobebaeigek\",\"brand\":\"GGLS\",\"cohort\":\"1:3cjr:\",\"cohorthint\":\"4.10.2557.0 for Chrome 95+\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\""
		"ping_freshness\":\"{bfed3660-5eb8-4001-ba07-a79e5985fc85}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"4.10.2934.0\"},{\"appid\":\"niikhdgajlphfehepabhhblakbdgeefj\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"38c89b12bb20a8f2751c9c7cd2e31c173a47af08c115e1ecccc2f5151a2cf2c6\"}],\"cohort\":\"1:1uh3:\",\"cohortname\":\"Auto Main Cohort.\",\"enabled\":true,\"installdate\":6132,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{1514b619-bc11-43ac-81a5-b81291db948a}\",\"rd\":6939},\""
		"updatecheck\":{},\"version\":\"2025.7.18.0\"},{\"appid\":\"lmelglejhemejginpboagddgdfbepgmp\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"7e09b4b30caa4a344a9a77f81f1e7a7fbf127b1b01d184e9515f3d1efbabf91d\"}],\"cohort\":\"1:lwl:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{86940bfb-097d-491b-a06f-c5b8c4a2e181}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"597\"},{\"appid\":\"pkomkdjpmjfbkgjjmmaioegaojgdahkm\",\"brand\""
		":\"GGLS\",\"cohort\":\"1:2m6f:\",\"cohortname\":\"Everybody\",\"enabled\":true,\"installdate\":6532,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{2098171b-b8dd-41d6-8b69-59a39094f0df}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"6.7431.9692\"},{\"appid\":\"jamhcnnkihinmdlkakkaopbjbbcngflc\",\"brand\":\"GGLS\",\"cohort\":\"1:wvr:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{a1876869-2bf6-4bce-a381-3df571ac58e1}\",\"rd"
		"\":6939},\"updatecheck\":{},\"version\":\"120.0.6050.0\"},{\"appid\":\"kiabhabjdbkjdpjbpigfodbdjmbglcoo\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"caf22da361a099ee7f504cfd6018872cff61e16946d0a5a57fb07c529bfa8072\"}],\"cohort\":\"1:v3l:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{d642467e-f904-4a2d-87e6-b6a81e8f86f8}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"2025.9.29.1\"},{\"appid\":\""
		"ninodabcejpeglfjbkhdplaoglpcbffj\",\"brand\":\"GGLS\",\"enabled\":true,\"installdate\":6917,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{f200b765-6cdb-44d8-8f1d-4b52ec98d5fd}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"0.0.0.0\"},{\"appid\":\"giekcmmlnklenlaomppkphknjmnnpneh\",\"brand\":\"GGLS\",\"cohort\":\"1:j5l:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{c1e69824-86ac-4500-8dcf-3e9737e056f7}\",\"rd\":6939},\""
		"updatecheck\":{},\"version\":\"7\"},{\"appid\":\"laoigpblnllgcgjnjnllmfolckpjlhki\",\"brand\":\"GGLS\",\"cohort\":\"1:10zr:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{6bb7fded-3774-40e6-add4-71970b2c3776}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"1.0.7.1744928549\"},{\"accept_locale\":\"ENUS500000\",\"appid\":\"obedbbhbpmojnkanicioggnmelmoomoc\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\""
		"40bcac8ec67b813b5a01fc4f2a820ff6f3311bb2c44b8bcd11e905f4a453ca19\"}],\"cohort\":\"1:s6f:3cr3@0.025\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{65024d8e-f988-4a59-ac50-be099aeeb6e1}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"20251020.824019708.14\"},{\"appid\":\"jflookgnkcckhobaglndicnbbgbonegd\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"d77d063235a7f16202526fb276f08bf219ba82ec65268695841ce285c5588d0d\"}],\""
		"cohort\":\"1:s7x:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{f72947cb-5f6b-4d47-a725-032092fe8e58}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"3089\"},{\"appid\":\"hfnkpimlhhgieaddgfemjhofmfblmnib\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"39b1280bf38a5787f6bb567f4821686e8bb6762abc9dfad967ded86ea383dffc\"}],\"cohort\":\"1:287f:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto full\",\"enabled\":true,\"lang\":\""
		"en-US\",\"ping\":{\"ping_freshness\":\"{bded7f7a-c676-4f0f-8d8c-f2cbe68f1581}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"10251\"},{\"appid\":\"jflhchccmppkfebkiaminageehmchikm\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"4a06cfbce6f26c81ec6cba52e84985c0111183e0b06a953b14992b4511bb78af\"}],\"cohort\":\"1:26yf:\",\"cohortname\":\"Stable\",\"enabled\":true,\"installdate\":6184,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{80f91854-eef7-4a47-b7c9-f07f1e762ad7}\",\"rd\":6939},\""
		"updatecheck\":{},\"version\":\"2025.10.7.1\"},{\"appid\":\"hajigopbbjhghbfimgkfmpenfkclmohk\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"abd93867c038d4d17c101ace2226d7e21303d984d7097271392bae6be478495b\"}],\"cohort\":\"1:2tdl:\",\"cohortname\":\"Stable\",\"enabled\":true,\"installdate\":6615,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{4711ce59-e6f5-4a66-b0e3-504082767d07}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"4\"},{\"appid\":\"ldfkbgjbencjpgjfleiooeldhjdapggh\",\"brand\":"
		"\"GGLS\",\"cached_items\":[{\"sha256\":\"38582b0c9b1c6d2f052dc20f30201c30698f3c6a4f3da4567991bf5629b1fa94\"}],\"cohort\":\"1:2v8l:\",\"cohortname\":\"Auto\",\"enabled\":true,\"installdate\":6673,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{1542ed35-4c14-4ff4-a3dd-e9f32e4e12c1}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"2025.8.19.0\"},{\"appid\":\"bjbcblmdcnggnibecjikpoljcgkbgphl\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\""
		"1492c484480e0e79ba7167ec429d6dd98f31d24d30420f8bc7124e11f8726e9c\"}],\"cohort\":\"1:2t4f:\",\"cohortname\":\"Stable\",\"enabled\":true,\"installdate\":6829,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{6ed722c8-c710-424c-9b02-31f95e67027e}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"20251215.1\"},{\"appid\":\"mcfjlbnicoclaecapilmleaelokfnijm\",\"brand\":\"GGLS\",\"cohort\":\"1:2ql3:\",\"cohortname\":\"Initial upload\",\"enabled\":true,\"installdate\":6651,\"lang\":\"en-US\",\"ping\":{\""
		"ping_freshness\":\"{f8c716e8-47af-471f-b80e-4e69c4e4b52f}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"2024.11.26.0\"},{\"appid\":\"ojhpjlocmbogdgmfpkhlaaeamibhnphh\",\"brand\":\"GGLS\",\"cohort\":\"1:w0x:\",\"cohorthint\":\"Auto\",\"cohortname\":\"All users\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{79ed12bb-9ea7-4a9d-af2f-0a97f0331a5b}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"3\"},{\"appid\":\"gcmjkmgdlgnkkcocmoeiminaijmmjnii\",\"brand\":\"GGLS\",\""
		"cached_items\":[{\"sha256\":\"ed43e732234cc8b79a137be0a0aab8f72b37ae6ca51caf1292986edbf618c1d1\"}],\"cohort\":\"1:bm1:\",\"cohorthint\":\"M54AndUp\",\"cohortname\":\"Stable\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{b658d624-840f-4eb4-b443-240b6c606e34}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"9.64.0\"},{\"appid\":\"efniojlnjndmcbiieegkicadnoecjjef\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\""
		"d207666f5d338e4392f2853a41e5ff4de1e7a719feb7a56648bc07e0882370f4\"}],\"cohort\":\"1:18ql:\",\"cohorthint\":\"Auto Stage3\",\"cohortname\":\"Auto Stage3\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{a03db207-a965-444b-bd1a-0ce3cf17801f}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"1537\"},{\"appid\":\"ggkkehgbnfjpeggfpleeakpidbkibbmn\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"1a9b02293d39d659a2f69fbe670d6a6816b0f83ff69f6ed0aec9e19329353851\"}],\"cohort\":\"1:ut9"
		"/1a0f:\",\"cohorthint\":\"108-and-above-all-users\",\"cohortname\":\"M108 and Above\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{9358e7ef-730f-4a16-9aeb-fff45be0b23a}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"2025.12.29.121\"},{\"appid\":\"cocncanleafgejenidihemfflagifjic\",\"brand\":\"GGLS\",\"cohort\":\"1:13hr:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Everyone Else\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\""
		"{218e8903-f54c-4021-83ef-0ddca5014003}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"2023.3.30.1305\"},{\"appid\":\"llkgjffcdpffmhiakmfcdcblohccpfmo\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"2be74d0afadd4c9b2ee33695e1f81fc5ce5dc3016cd8a13cfa0e1f0b571834ea\"}],\"cohort\":\"1::\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{619fa42a-0bed-4e6f-a28b-1feddf908a18}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"1.0.0.19\"},{\"appid\":\""
		"khaoiebndkojlmppeemjhbpbandiljpe\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"261bea60d22ebca3a95ce335c03ec751a0b58b2b7bdbd6ea51dfa54381b07775\"}],\"cohort\":\"1:cux:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{252fdd40-50bc-40ce-9e71-32bda3627a42}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"145.0.7584.0\"},{\"appid\":\"pmagihnlncbcefglppponlgakiphldeh\",\"brand\":\"GGLS\",\"cohort\":\"1:2ntr:\",\"cohortname\":\""
		"General Release\",\"enabled\":true,\"installdate\":6651,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{4205c690-1cb1-40b1-a8d7-1b8f5f8fe8c7}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"2024.10.17.0\"},{\"appid\":\"eeigpngbgcognadeebkilcpcaedhellh\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"4497d8060d0e53c12b4403aa9ebe7e827d4880bae3f4139a26a4feb7ed64c4a2\"}],\"cohort\":\"1:w59:\",\"cohorthint\":\"Auto\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\""
		"ping_freshness\":\"{4829a3d5-8742-4140-b237-5680e3864d01}\",\"rd\":6939},\"updatecheck\":{},\"version\":\"2025.6.13.84507\"},{\"appid\":\"gonpemdgkjcecdgbnaabipppbmgfggbe\",\"brand\":\"GGLS\",\"cached_items\":[{\"sha256\":\"56c21927faa028be6ce18c931660eec37e41da4bfbfd47cafa48350f828c0dbd\"}],\"cohort\":\"1:z1x:\",\"cohorthint\":\"General release\",\"cohortname\":\"Auto\",\"enabled\":true,\"lang\":\"en-US\",\"ping\":{\"ping_freshness\":\"{4fa15fa6-15dd-43c7-b9c8-aa6bfeb6c72d}\",\"rd\":6939},\""
		"updatecheck\":{},\"version\":\"2025.7.24.0\"}],\"arch\":\"x64\",\"dedup\":\"cr\",\"domainjoined\":true,\"hw\":{\"avx\":true,\"physmemory\":32,\"sse\":true,\"sse2\":true,\"sse3\":true,\"sse41\":true,\"sse42\":true,\"ssse3\":true},\"ismachine\":true,\"os\":{\"arch\":\"x86_64\",\"platform\":\"Windows\",\"version\":\"10.0.19045.6466\"},\"prodversion\":\"143.0.7499.170\",\"protocol\":\"4.0\",\"requestid\":\"{3db0f86e-fd72-4c7d-aaca-2223d604d7be}\",\"sessionid\":\"{42d83893-48f6-4d81-9c52-8727820d9177}"
		"\",\"updaters\":{\"autoupdatecheckenabled\":true,\"ismachine\":true,\"lastchecked\":0,\"laststarted\":0,\"name\":\"ChromiumUpdater\",\"updatepolicy\":-1,\"version\":\"144.0.7547.0\"},\"updaterversion\":\"143.0.7499.170\"}}", 
		LAST);

	web_custom_request("v2_2", 
		"URL=https://clientservices.googleapis.com/uma/v2", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=", 
		"Snapshot=t8.inf", 
		"ContentEncoding=gzip", 
		"Mode=HTML", 
		"EncType=application/vnd.chrome.uma", 
		body_variable_1, 
		LAST);

	web_add_cookie("userCart=%7B%22userId%22%3A-1%2C%22productsInCart%22%3A%5B%5D%7D; DOMAIN=advantageonlineshopping.com");

	web_url("ALL", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/DemoAppConfig/parameters/by_tool/ALL", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t9.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=/css/fonts/roboto_regular_macroman/Roboto-Regular-webfont.woff", "Referer=https://advantageonlineshopping.com/css/main.min.css", ENDITEM, 
		"Url=/css/fonts/roboto_medium_macroman/Roboto-Medium-webfont.woff", "Referer=https://advantageonlineshopping.com/css/main.min.css", ENDITEM, 
		"Url=/css/fonts/roboto_light_macroman/Roboto-Light-webfont.woff", "Referer=https://advantageonlineshopping.com/css/main.min.css", ENDITEM, 
		LAST);

	lr_think_time(4);

	web_custom_request("collect", 
		"URL=https://www.google-analytics.com/j/collect?v=1&_v=j102&a=102167564&t=pageview&_s=1&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dp=%2F&ul=en&dt=%C2%A0Advantage%20Shopping&sr=1920x1080&vp=1920x929&_u=IEBAAEABAAAAACAAI~&jid=1519501379&gjid=720237036&cid=1882700821.1767196440&tid=UA-81334227-1&_gid=1942207357.1767196440&_r=1&_slc=1&z=1295386439", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t10.inf", 
		"Mode=HTML", 
		"EncType=text/plain", 
		EXTRARES, 
		"Url=https://content-autofill.googleapis.com/v1/pages/ChVDaHJvbWUvMTQzLjAuNzQ5OS4xNzASLgk0obaTTtv-JhIFDeeNQA4SBQ3OQUx6EgUNeG8SGRIFDQ8WvishPHbFEvZHhmIYt6nKAQ==?alt=proto", "Referer=", ENDITEM, 
		LAST);

	web_add_cookie("_gid=GA1.2.1942207357.1767196440; DOMAIN=advantageonlineshopping.com");

	web_add_cookie("_gat=1; DOMAIN=advantageonlineshopping.com");

	web_add_cookie("_ga_TBPYED8WSW=GS2.1.s1767196444$o1$g0$t1767196444$j60$l0$h0; DOMAIN=advantageonlineshopping.com");

	web_add_cookie("_ga=GA1.1.1882700821.1767196440; DOMAIN=advantageonlineshopping.com");

	web_custom_request("GetAccountConfigurationRequest", 
		"URL=https://advantageonlineshopping.com/accountservice/ws/GetAccountConfigurationRequest", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/xml", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t11.inf", 
		"Mode=HTML", 
		"EncType=text/xml; charset=UTF-8", 
		"Body=<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><GetAccountConfigurationRequest xmlns=\"com.advantage.online.store.accountservice\"></GetAccountConfigurationRequest></soap:Body></soap:Envelope>", 
		LAST);

	lr_think_time(9);

	web_custom_request("collect_2", 
		"URL=https://analytics.google.com/g/collect?v=2&tid=G-56EMNRF2S2&gtm=45je5ca1v9126552653za20g&_p=1767196434554&_gaz=1&gcd=13l3l3l3l2l1&npa=0&dma=0&ul=en&sr=1920x1080&cid=1882700821.1767196440&ir=1&uaa=x86&uab=64&uafvl=Google%2520Chrome%3B143.0.7499.170%7CChromium%3B143.0.7499.170%7CNot%2520A(Brand%3B24.0.0.0&uamb=0&uam=&uap=Windows&uapv=10.0.0&uaw=0&are=1&frm=0&pscdl=noapi&_eu=EBAI&_s=1&tag_exp=103116026~103200004~104527907~104528500~104684208~104684211~105391253~115495939~115583767~115616985~"
		"115938465~115938469~116184927~116184929~116251938~116251940~116682877~116744866&dl=https%3A%2F%2Fadvantageonlineshopping.com%2F&dp=%2F&dt=%C2%A0Advantage%20Shopping&sid=1767196444&sct=1&seg=0&_tu=wAQ&en=page_view&_fv=1&_ss=1&_ee=1&tfd=57881", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t12.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);

	web_add_cookie("_ga_56EMNRF2S2=GS2.2.s1767196444$o1$g0$t1767196444$j60$l0$h0; DOMAIN=advantageonlineshopping.com");

	web_url("categories", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/categories", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t13.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("eyeo-ga-consent=true; DOMAIN=easylist-downloads.adblockplus.org");

	web_add_cookie("eyeo-ga-opt-out=true; DOMAIN=easylist-downloads.adblockplus.org");

	web_add_cookie("_ga_VCX0BRJMZ3=GS1.1.1739389347.4.1.1739389367.0.0.0; DOMAIN=easylist-downloads.adblockplus.org");

	web_add_cookie("eyeo-seen-cookie-prompt=1; DOMAIN=easylist-downloads.adblockplus.org");

	web_add_cookie("optimizelyEndUserId=oeu1742317151852r0.18106693648596917; DOMAIN=easylist-downloads.adblockplus.org");

	web_add_cookie("optimizelySession=0; DOMAIN=easylist-downloads.adblockplus.org");

	web_url("experiments.json", 
		"URL=https://easylist-downloads.adblockplus.org/ab-testing/experiments.json", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=", 
		"Snapshot=t14.inf", 
		"Mode=HTML", 
		LAST);

	web_custom_request("collect_3", 
		"URL=https://stats.g.doubleclick.net/g/collect?v=2&tid=G-56EMNRF2S2&cid=1882700821.1767196440&gtm=45je5ca1v9126552653za20g&aip=1&dma=0&gcd=13l3l3l3l2l1&npa=0&frm=0&tag_exp=103116026~103200004~104527907~104528500~104684208~104684211~105391253~115495939~115583767~115616985~115938465~115938469~116184927~116184929~116251938~116251940~116682877~116744866", 
		"Method=POST", 
		"Resource=0", 
		"RecContentType=text/plain", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t15.inf", 
		"Mode=HTML", 
		"EncType=", 
		LAST);

	web_url("search", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/deals/search?dealOfTheDay=true", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t16.inf", 
		"Mode=HTML", 
		LAST);

	web_url("popularProducts.json", 
		"URL=https://advantageonlineshopping.com/app/tempFiles/popularProducts.json", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t17.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("_ga_56EMNRF2S2=GS2.2.s1767196444$o1$g1$t1767196461$j43$l0$h0; DOMAIN=advantageonlineshopping.com");

	web_url("home-page.html", 
		"URL=https://advantageonlineshopping.com/app/views/home-page.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t18.inf", 
		"Mode=HTML", 
		EXTRARES, 
		"Url=/css/images/arrow_right.png", "Referer=https://advantageonlineshopping.com/css/main.min.css", ENDITEM, 
		"Url=/css/fonts/roboto_bold_macroman/Roboto-Bold-webfont.woff", "Referer=https://advantageonlineshopping.com/css/main.min.css", ENDITEM, 
		"Url=/css/fonts/roboto_thin_macroman/Roboto-Thin-webfont.woff", "Referer=https://advantageonlineshopping.com/css/main.min.css", ENDITEM, 
		LAST);

	lr_think_time(8);

	web_url("products", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/categories/4/products", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t19.inf", 
		"Mode=HTML", 
		LAST);

	web_url("attributes", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/categories/attributes", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t20.inf", 
		"Mode=HTML", 
		LAST);

	web_url("category-page.html", 
		"URL=https://advantageonlineshopping.com/app/views/category-page.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t21.inf", 
		"Mode=HTML", 
		LAST);

	lr_think_time(4);

	web_url("24", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/products/24", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t22.inf", 
		"Mode=HTML", 
		LAST);

	web_url("all_data", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/categories/all_data", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t23.inf", 
		"Mode=HTML", 
		LAST);

	web_url("products_2", 
		"URL=https://advantageonlineshopping.com/catalog/api/v1/categories/4/products", 
		"Resource=0", 
		"RecContentType=application/json", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t24.inf", 
		"Mode=HTML", 
		LAST);

	web_url("product-page.html", 
		"URL=https://advantageonlineshopping.com/app/views/product-page.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t25.inf", 
		"Mode=HTML", 
		LAST);

	web_add_cookie("userCart=%7B%22userId%22%3A-1%2C%22productsInCart%22%3A%5B%7B%22productId%22%3A24%2C%22imageUrl%22%3A%224600%22%2C%22productName%22%3A%22HP%20Roar%20Mini%20Wireless%20Speaker%22%2C%22color%22%3A%7B%22code%22%3A%22DD3A5B%22%2C%22name%22%3A%22RED%22%2C%22inStock%22%3A10%2C%22%24%24hashKey%22%3A%22object%3A302%22%7D%2C%22quantity%22%3A1%2C%22price%22%3A44.99%2C%22hasWarranty%22%3Afalse%7D%5D%7D; DOMAIN=advantageonlineshopping.com");

	web_add_cookie("_ga_56EMNRF2S2=GS2.2.s1767196444$o1$g1$t1767196496$j8$l0$h0; DOMAIN=advantageonlineshopping.com");

	lr_think_time(18);

	web_url("shoppingCart.html", 
		"URL=https://advantageonlineshopping.com/app/views/shoppingCart.html", 
		"Resource=0", 
		"RecContentType=text/html", 
		"Referer=https://advantageonlineshopping.com/", 
		"Snapshot=t26.inf", 
		"Mode=HTML", 
		LAST);

	return 0;
}