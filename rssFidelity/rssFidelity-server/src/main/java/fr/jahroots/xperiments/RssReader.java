package fr.jahroots.xperiments;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * @author Jahroots
 */
public class RssReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(RssReader.class);

    public static void main(String[] args) {

    }

    public SyndFeed getSyndFeed(final URL rssUrl) {
        SyndFeed feed = null;
        try {
            final XmlReader reader = new XmlReader(rssUrl);
            feed = new SyndFeedInput().build(reader);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (FeedException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return feed;
    }
}
