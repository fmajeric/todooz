package fr.todooz.util;

import java.util.ArrayList;
import java.util.List;

public class TagCloud {
	private List<String> tags = new ArrayList<String>();

	public void add(String... tags) {
		if (tags == null) {
			return;
		}
		
		for (String tag : tags) {
			if (tag != null && !contains(tag)) {
				this.tags.add(tag);
			}
		}

	}

	public int size() {
		return tags.size();
	}

	public boolean contains(String string) {
		return tags.contains(string);
	}

	@Override
	public String toString() {
		return "TagCloud [tags=" + tags + "]";
	}

}