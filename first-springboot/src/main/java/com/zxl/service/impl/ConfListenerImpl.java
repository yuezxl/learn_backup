package com.zxl.service.impl;

import com.jd.std.ucc.client.event.ConfListener;

public class ConfListenerImpl implements ConfListener {

	@Override
	public void exceptionCaught(Throwable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleConfig(String arg0) {
		System.out.println("=======================");
		System.out.println("the new value is " + arg0);

	}

}
