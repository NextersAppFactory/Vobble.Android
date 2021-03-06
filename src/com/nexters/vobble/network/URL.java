package com.nexters.vobble.network;

import com.nexters.vobble.core.App;

public class URL {
	public static final String BASE_URL_DEVELOPMENT = "http://54.199.171.240:3000";
	public static final String BASE_URL_PRODUCTION = "http://vobbletestapi.cafe24app.com";
	public static final String getBaseUrl() {
		if(App.SERVER_TARGET == App.SERVER_TEST) {
			return BASE_URL_DEVELOPMENT;
		} else {
			return BASE_URL_PRODUCTION;
		}
	}

    public static final String SIGN_UP = getBaseUrl() + "/users";
	public static final String SIGN_IN = getBaseUrl() + "/tokens";
	public static final String VOBBLES = getBaseUrl() + "/vobbles";
    public static final String VOBBLES_COUNT = getBaseUrl() + "/vobbles/count";
	public static final String VOBBLES_CREATE = getBaseUrl() + "/users/%s/vobbles";
    public static final String USER_INFO = getBaseUrl() + "/users/%s";
    public static final String USER_VOBBLES = getBaseUrl() + "/users/%s/vobbles";
    public static final String USER_VOBBLES_COUNT = getBaseUrl() + "/users/%s/vobbles/count";
	public static final String USER_VOBBLES_DELETE = getBaseUrl() + "/users/%s/vobbles/%s/delete";

    public static final String EVENTS = getBaseUrl() + "/events";
    public static final String MORE_APPS = "http://teamnexters.com/apps";
}
