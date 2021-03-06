package com.example.jna;
import com.example.jna.Libcurl4Library.curl_socket_t;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : include\curl\multi.h:113</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class curl_waitfd extends Structure {
	/** C type : curl_socket_t */
	public curl_socket_t fd;
	public short events;
	/** not supported yet */
	public short revents;
	public curl_waitfd() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("fd", "events", "revents");
	}
	/**
	 * @param fd C type : curl_socket_t<br>
	 * @param revents not supported yet
	 */
	public curl_waitfd(curl_socket_t fd, short events, short revents) {
		super();
		this.fd = fd;
		this.events = events;
		this.revents = revents;
	}
	public static class ByReference extends curl_waitfd implements Structure.ByReference {
		
	};
	public static class ByValue extends curl_waitfd implements Structure.ByValue {
		
	};
}
