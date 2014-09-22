package fr.jahroots.xperiments;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * @author Jahroots
 */
public class RssReaderTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(RssReaderTest.class);
    private static final String FEED_XML = "feed.xml";
    private RssReader rssReader;

    @Before
    public void setUp() {
        rssReader = new RssReader();
    }

    @Test
    public void getSyndFeed() {
        final URL url = this.getClass().getClassLoader().getResource(FEED_XML);
        final SyndFeed feed = rssReader.getSyndFeed(url);
        Assert.assertNotNull(feed);
        LOGGER.info(feed.getTitle() + ": " + feed.getEntries().size() + " entries");
        LOGGER.info(new Date(feed.getPublishedDate().getTime()).toString());
    }
}
