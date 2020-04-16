package com.mascotcapsule.micro3d.v3.render;

public class Shader {

	public static final String textureVertex =
			// This matrix member variable provides a hook to manipulate
			// the coordinates of the objects that use this vertex shader
			"uniform mat4 uMVPMatrix;" +
					"attribute vec4 vPosition;" +
					"attribute vec2 aTexture;" +
					"varying vec2 vTexture;" +
					"uniform vec2 uTranslationOffset;" +
					"uniform vec2 uTextureSize;" +
					"void main() {" +
					"  gl_Position = uMVPMatrix * vPosition;" +
					"  gl_Position.xy += uTranslationOffset * gl_Position.w;" +
					"  vTexture = aTexture / uTextureSize;" +
					"}";

	public static final String textureFragment =
			"precision mediump float;" +
					"uniform sampler2D uTextureUnit;" +
					"varying vec2 vTexture;" +
					"void main() {" +
					"  gl_FragColor = texture2D(uTextureUnit, vTexture);" +
					"}";

	public static final String colorVertex =
			"uniform mat4 uMVPMatrix;" +
					"attribute vec4 vPosition;" +
					"attribute vec4 aColor;" +
					"varying vec4 vColor;" +
					"uniform vec2 uTranslationOffset;" +
					"void main() {" +
					"  gl_Position = uMVPMatrix * vPosition;" +
					"  gl_Position.xy += uTranslationOffset * gl_Position.w;" +
					"  vColor = aColor;" +
					"}";

	public static final String colorFragment =
			"precision mediump float;" +
					"varying vec4 vColor;" +
					"void main() {" +
					"  gl_FragColor = vColor;" +
					"}";
}