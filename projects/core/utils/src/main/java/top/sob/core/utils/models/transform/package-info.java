/**
 * URL Classpath Transformation and Extension model. An IPM. Use for generating more URLs for a classpath (class URL[]).
 * <p>
 * Here is an example :
 * <br>
 * Imagine a file folder url <code>file://example/classpath</code> and there are two JAR files with an url of
 * <code>file://example/classpath/a.jar</code> and <code>file://example/classpath/b.jar</code>. Normally if you want to
 * make an URLClassLoader and have the classpath of the 2 JAR files, but you only have the URL of the classpath`s folder,
 * then you need to write a lot of messy code using {@link java.net.URL#toURI()}, {@link java.io.File#File(java.net.URI)}
 * and {@link java.io.File#listFiles()}. But with this model, you just only need to write the code
 * <blockquote><pre>Transformer.getDefault().transform(classpath)</pre></blockquote>.
 */
package top.sob.core.utils.models.transform;