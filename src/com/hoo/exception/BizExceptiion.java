package com.hoo.exception;

import org.springframework.dao.DataAccessException;

public class BizExceptiion extends DataAccessException  {

	public BizExceptiion(String string) {
		super(string);
	}

	
	public BizExceptiion(String msg, Throwable cause) {
		super(msg, cause);
	}


	private static final long serialVersionUID = 1L;

}
