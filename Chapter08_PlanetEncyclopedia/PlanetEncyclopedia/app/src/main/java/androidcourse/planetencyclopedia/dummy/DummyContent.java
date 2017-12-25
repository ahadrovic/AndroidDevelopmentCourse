package androidcourse.planetencyclopedia.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidcourse.planetencyclopedia.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    //private static final int COUNT = 25;

    static {
        // Adding sample planet items
        addItem(new DummyItem("1", "Earth", "Earth is the third planet from the Sun and the only object in the Universe known to harbor life.  " +
                "It is the densest planet in the Solar System and the largest of the four terrestrial planets." +
                "Over 7.4 billion humans live on Earth and depend on its biosphere and minerals for their survival."));
        addItem(new DummyItem("2", "Mars", "Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System, after Mercury." +
                "        Named after the Roman god of war, it is often referred to as the Red Planet because the iron oxide prevalent on its surface gives it a reddish appearance." +
                "    Mars is a terrestrial planet with a thin atmosphere, having surface features reminiscent both of the impact craters of the Moon and the valleys, deserts, and polar ice caps of Earth."));
        addItem(new DummyItem("3", "Jupiter", "Jupiter is the fifth planet from the Sun and the largest in the Solar System.\n" +
                "        It is a giant planet with a mass one-thousandth that of the Sun, but two and a half times that of all the other planets in the Solar System combined.\n" +
                "        Jupiter is a gas giant, along with Saturn, with the other two giant planets, Uranus and Neptune, being ice giants.\n" +
                "        Jupiter was known to astronomers of ancient times."));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        //If you want, you can add a planet image, or some other piece of information here
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
