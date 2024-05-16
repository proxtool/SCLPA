/**
 * This class file was automatically generated by jASN1 v1.11.3 (http://www.beanit.com)
 */

package com.gsma.sgp.messages.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;

import com.gsma.sgp.messages.pkix1explicit88.Certificate;
import com.gsma.sgp.messages.pkix1explicit88.CertificateList;
import com.gsma.sgp.messages.pkix1explicit88.Time;
import com.gsma.sgp.messages.pkix1implicit88.SubjectKeyIdentifier;

public class PrepareDownloadRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 33);

	public byte[] code = null;
	private SmdpSigned2 smdpSigned2 = null;
	private BerOctetString smdpSignature2 = null;
	private Octet32 hashCc = null;
	private Certificate smdpCertificate = null;
	
	public PrepareDownloadRequest() {
	}

	public PrepareDownloadRequest(byte[] code) {
		this.code = code;
	}

	public void setSmdpSigned2(SmdpSigned2 smdpSigned2) {
		this.smdpSigned2 = smdpSigned2;
	}

	public SmdpSigned2 getSmdpSigned2() {
		return smdpSigned2;
	}

	public void setSmdpSignature2(BerOctetString smdpSignature2) {
		this.smdpSignature2 = smdpSignature2;
	}

	public BerOctetString getSmdpSignature2() {
		return smdpSignature2;
	}

	public void setHashCc(Octet32 hashCc) {
		this.hashCc = hashCc;
	}

	public Octet32 getHashCc() {
		return hashCc;
	}

	public void setSmdpCertificate(Certificate smdpCertificate) {
		this.smdpCertificate = smdpCertificate;
	}

	public Certificate getSmdpCertificate() {
		return smdpCertificate;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		codeLength += smdpCertificate.encode(reverseOS, true);
		
		if (hashCc != null) {
			codeLength += hashCc.encode(reverseOS, true);
		}
		
		codeLength += smdpSignature2.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 55
		reverseOS.write(0x37);
		reverseOS.write(0x5F);
		codeLength += 2;
		
		codeLength += smdpSigned2.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(SmdpSigned2.tag)) {
			smdpSigned2 = new SmdpSigned2();
			subCodeLength += smdpSigned2.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
			smdpSignature2 = new BerOctetString();
			subCodeLength += smdpSignature2.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(Octet32.tag)) {
			hashCc = new Octet32();
			subCodeLength += hashCc.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		
		if (berTag.equals(Certificate.tag)) {
			smdpCertificate = new Certificate();
			subCodeLength += smdpCertificate.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (smdpSigned2 != null) {
			sb.append("smdpSigned2: ");
			smdpSigned2.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("smdpSigned2: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (smdpSignature2 != null) {
			sb.append("smdpSignature2: ").append(smdpSignature2);
		}
		else {
			sb.append("smdpSignature2: <empty-required-field>");
		}
		
		if (hashCc != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("hashCc: ").append(hashCc);
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (smdpCertificate != null) {
			sb.append("smdpCertificate: ");
			smdpCertificate.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("smdpCertificate: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

