package com.example.jna;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * Information about the SSL library used and the respective internal SSL<br>
 * handle, which can be used to obtain further information regarding the<br>
 * connection. Asked for with CURLINFO_TLS_SSL_PTR or CURLINFO_TLS_SESSION.<br>
 * <i>native declaration : include\curl\curl.h:2474</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class curl_tlssessioninfo extends Structure {
	/**
	 * @see curl_sslbackend<br>
	 * C type : curl_sslbackend
	 */
	public int backend;
	/** C type : void* */
	public Pointer internals;
	public curl_tlssessioninfo() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("backend", "internals");
	}
	/**
	 * @param backend @see curl_sslbackend<br>
	 * C type : curl_sslbackend<br>
	 * @param internals C type : void*
	 */
	public curl_tlssessioninfo(int backend, Pointer internals) {
		super();
		this.backend = backend;
		this.internals = internals;
	}
	public static class ByReference extends curl_tlssessioninfo implements Structure.ByReference {
		
	};
	public static class ByValue extends curl_tlssessioninfo implements Structure.ByValue {
		
	};
}
