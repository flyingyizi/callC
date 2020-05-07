package com.example.jna;
import com.example.jna.Libcurl4Library.sockaddr;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : include\curl\curl.h:335</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class curl_sockaddr extends Structure {
	public int family;
	public int socktype;
	public int protocol;
	/**
	 * addrlen was a socklen_t type before 7.18.0 but it<br>
	 * turned really ugly and painful on the systems that<br>
	 * lack this type
	 */
	public int addrlen;
	/** C type : sockaddr */
	public sockaddr addr;
	public curl_sockaddr() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("family", "socktype", "protocol", "addrlen", "addr");
	}
	/**
	 * @param addrlen addrlen was a socklen_t type before 7.18.0 but it<br>
	 * turned really ugly and painful on the systems that<br>
	 * lack this type<br>
	 * @param addr C type : sockaddr
	 */
	public curl_sockaddr(int family, int socktype, int protocol, int addrlen, sockaddr addr) {
		super();
		this.family = family;
		this.socktype = socktype;
		this.protocol = protocol;
		this.addrlen = addrlen;
		this.addr = addr;
	}
	public static class ByReference extends curl_sockaddr implements Structure.ByReference {
		
	};
	public static class ByValue extends curl_sockaddr implements Structure.ByValue {
		
	};
}
