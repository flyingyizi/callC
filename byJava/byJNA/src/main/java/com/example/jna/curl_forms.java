package com.example.jna;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * structure to be used as parameter for CURLFORM_ARRAY<br>
 * <i>native declaration : include\curl\curl.h:2195</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class curl_forms extends Structure {
	/**
	 * @see CURLformoption<br>
	 * C type : CURLformoption
	 */
	public int option;
	/** C type : const char* */
	public Pointer value;
	public curl_forms() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("option", "value");
	}
	/**
	 * @param option @see CURLformoption<br>
	 * C type : CURLformoption<br>
	 * @param value C type : const char*
	 */
	public curl_forms(int option, Pointer value) {
		super();
		this.option = option;
		this.value = value;
	}
	public static class ByReference extends curl_forms implements Structure.ByReference {
		
	};
	public static class ByValue extends curl_forms implements Structure.ByValue {
		
	};
}
