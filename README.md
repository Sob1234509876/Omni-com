Omni com
===
A little game which it has __Nearly__ no GUI! This game is being inspired by a game on Crazy Games called "Space
Company"<p>
Link : https://www.crazygames.com/game/space-company<p>
![logo_HAND_MADE_TM](https://static.wikia.nocookie.net/omni-com-official/images/2/29/Blank_128x128.png) The logo of this
game.

Compiling
===
Simply run <code>gradlew build</code>.

Running
===
To run the core, run command <code>gradlew core:run</code>.<p>
To run the core with Vanilla plugin installed, run command <code>gradlew vanilla:runByCore</code>.

Change logs :
===
See [here](https://omni-com-official.fandom.com/wiki/Change_log) at the fandom wiki.

Q&A :
===
Q: Why did the game crashed on the first time of launch? This is what it said in log :<p>

> \[ERROR]\[org.apache.log4j.Category:top.sob.core.Utilities]\[main]\[null]\[at top.sob.core.Main.main (Main.java:
> 71)]\[]\[$DATE TIME$]<p>

> Exception in Utilities#getConfig(String...) :java.lang.RuntimeException: java.util.concurrent.ExecutionException:
> java.io.FileNotFoundException: .../core.cfg (I see no files)

> * at top.sob.core.Utilities.getToml(Utilities.java:179)<br>
    at top.sob.core.Utilities.getConfig(Utilities.java:108)<br>
    at top.sob.core.Utilities.getConfig(Utilities.java:159)<br>
    at top.sob.core.api.Meta.<clinit>(Meta.java:74)<br>
    at top.sob.core.Utilities.<clinit>(Utilities.java:57)<br>
    at top.sob.core.Utilities\$DefConsoleLayout.getLevelString(Utilities.java:343)<br>
    at top.sob.core.Utilities\$DefLayout.format(Utilities.java:213)<br>
    at org.apache.log4j.WriterAppender.subAppend(WriterAppender.java:310)<br>
    at org.apache.log4j.WriterAppender.append(WriterAppender.java:162)<br>
    at org.apache.log4j.AppenderSkeleton.doAppend(AppenderSkeleton.java:251)<br>
    at org.apache.log4j.helpers.AppenderAttachableImpl.appendLoopOnAppenders(AppenderAttachableImpl.java:66)<br>
    at org.apache.log4j.Category.callAppenders(Category.java:206)<br>
    at org.apache.log4j.Category.forcedLog(Category.java:391)<br>
    at org.apache.log4j.Category.info(Category.java:666)<br>
    at top.sob.core.Main.main(Main.java:71)<br>

> Caused by: java.util.concurrent.ExecutionException: java.io.FileNotFoundException: .../core.cfg (I see no
> files)

> * at com.google.common.util.concurrent.AbstractFuture.getDoneValue(AbstractFuture.java:596)<br>
    at com.google.common.util.concurrent.AbstractFuture.get(AbstractFuture.java:555)<br>
    at com.google.common.util.concurrent.AbstractFuture\$TrustedFuture.get(AbstractFuture.java:111)<br>
    at com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(Uninterruptibles.java:247)<br>
    at com.google.common.cache.LocalCache\$Segment.getAndRecordStats(LocalCache.java:2349)<br>
    at com.google.common.cache.LocalCache\$Segment.loadSync(LocalCache.java:2317)<br>
    at com.google.common.cache.LocalCache\$Segment.lockedGetOrLoad(LocalCache.java:2189)<br>
    at com.google.common.cache.LocalCache\$Segment.get(LocalCache.java:2079)<br>
    at com.google.common.cache.LocalCache.get(LocalCache.java:4017)<br>
    at com.google.common.cache.LocalCache\$LocalManualCache.get(LocalCache.java:4898)<br>
    at top.sob.core.Utilities.getToml(Utilities.java:177)<br>
    ... 14 more<br>

> Caused by: java.io.FileNotFoundException: .../core.cfg (I see no files)

> * at java.base/java.io.FileInputStream.open0(Native Method)<br>
    at java.base/java.io.FileInputStream.open(FileInputStream.java:216)<br>
    at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)<br>
    at java.base/java.io.FileInputStream.<init>(FileInputStream.java:111)<br>
    at java.base/sun.net.www.protocol.file.FileURLConnection.connect(FileURLConnection.java:86)<br>
    at java.base/sun.net.www.protocol.file.FileURLConnection.getInputStream(FileURLConnection.java:189)<br>
    at java.base/java.net.URL.openStream(URL.java:1161)<br>
    at top.sob.core.Utilities.lambda\$getToml\$0(Utilities.java:177)<br>
    at com.google.common.cache.LocalCache\$LocalManualCache\$1.load(LocalCache.java:4903)<br>
    at com.google.common.cache.LocalCache\$LoadingValueReference.loadFuture(LocalCache.java:3574)<br>
    at com.google.common.cache.LocalCache\$Segment.loadSync(LocalCache.java:2316)<br>
    ... 19 more<br>

> ...

A: Probably because the core is generating configurations and temporary files. The author does not want to fix this bug,
it will cause a lot of other problems. The reason for this is when the core initializes, the `Main` class will
initialize the logger with a layout called `Utilities.DefLayout`, this will also cause the class `Utilities` will also
been initialized. Getting a look closer into the class :

````
package top.sob.core;

import ...;

@Immutable
@Static
@API(status = API.Status.STABLE, since = "1.2.8a")
public final class Utilities {

    ...
    
    static {
        var CONF_URL = (URL) null;
        var LANG_URL = (URL) null;
        try {
            CONF_URL = Meta.CONFIGS_URI.toURL();
            LANG_URL = Objects.requireNonNull(Meta.THIS_CLASS_LOADER.getResource(""));
        } catch (MalformedURLException e) {
            throw new MalformedResourceException(Meta.CONFIGS_URI + "/core.cfg");
        } catch (NullPointerException e) {
            throw new IncompleteJarException("");
        }

        addResourceToConfPath(CONF_URL);
        addResourceToConfPath(LANG_URL);

    }
    
    // From here on most stuff are not important

    ...

    @Singleton(desc = """
            Singleton because of it is instance independent,
            meaning it has no differences between each other
            """, instance = """
            DefLayout#getInstance(),
            DefLayout#INSTANCE
            """)
    @API(status = API.Status.STABLE, since = "1.2.8a")
    public static class DefLayout extends Layout {

        @NotNull
        @API(status = API.Status.STABLE, since = "1.2.8a")
        public static Layout getInstance() {
            return INSTANCE;
        }

        private static final Layout INSTANCE = new DefLayout();

        ...

    }

    @Singleton(desc = "See Utilities.DefLayout", instance = "#INSTANCE; #getInstance()")
    @API(status = API.Status.STABLE, since = "1.2.8a")
    public static class DefConsoleLayout extends DefLayout {
    
        ...
        
        private static final Layout INSTANCE = new DefConsoleLayout();

        @NotNull
        @API(status = API.Status.STABLE, since = "1.2.8a")
        public static Layout getInstance() {
            return INSTANCE;
        }

        ...

    }

    ...

}
````

The main problem here is the line of code : `CONF_URL = Meta.CONFIGS_URI.toURL();`. And because this part of code has
been run before the duplication of configs etc. so the config is not available. All in all, what one needs to do is
re-run the core.
