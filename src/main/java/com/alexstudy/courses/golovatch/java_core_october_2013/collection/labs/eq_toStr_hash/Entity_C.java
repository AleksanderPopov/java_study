package golovatch.courses.collection.labs.eq_toStr_hash;

import java.util.*;

/**
 * Created by Alex on 12/13/2016.
 */
public class Entity_C {
    private final Entity_A entity;
    private final List<Entity_B> list;
    private final Map<Set<Entity_A>, List<Entity_B[]>> map;

    public Entity_C(Entity_A entity, List<Entity_B> list, Map<Set<Entity_A>, List<Entity_B[]>> map) {
        this.entity = entity;
        this.list = list;
        this.map = map;
    }

    public Entity_A getEntity() {
        return entity;
    }

    public List<Entity_B> getList() {
        return list;
    }

    public Map<Set<Entity_A>, List<Entity_B[]>> getMap() {
        return map;
    }

    @Override
    public int hashCode() {
        return 31 * entity.hashCode() + 31 * list.hashCode() + 31 * map.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Entity_C other = (Entity_C) obj;
        if (!this.entity.equals(other.entity)) return false;
        if (!Arrays.equals(this.list.toArray(), other.list.toArray())) return false;
        if (this.map.size() != other.map.size()) return false;
        Set<Map.Entry<Set<Entity_A>, List<Entity_B[]>>> thisEntries = this.map.entrySet();
        Set<Map.Entry<Set<Entity_A>, List<Entity_B[]>>> otherEntries = other.map.entrySet();
        Iterator<Map.Entry<Set<Entity_A>, List<Entity_B[]>>> thisIter = thisEntries.iterator();
        Iterator<Map.Entry<Set<Entity_A>, List<Entity_B[]>>> otherIter = otherEntries.iterator();
        while (thisIter.hasNext() && otherIter.hasNext()) {
            Map.Entry<Set<Entity_A>, List<Entity_B[]>> thisEntry = thisIter.next();
            Map.Entry<Set<Entity_A>, List<Entity_B[]>> otherEntry = otherIter.next();
            if (thisEntry.getKey().containsAll(otherEntry.getKey())
                    && otherEntry.getKey().containsAll(thisEntry.getKey()))
                return false;
            if (!Arrays.deepEquals(thisEntry.getValue().toArray(), otherEntry.getValue().toArray())) return false;
        }
        return true;
    }

    @SuppressWarnings("ignored")
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EntityC")
                .append("\n{\n")
                .append("entity='" + this.entity.toString() + "'\n")
                .append("list='" + this.list.toString() + "'\n")
                .append("map='");
        for (Map.Entry entry : map.entrySet()) {
            Set<Entity_A> key = (Set<Entity_A>) entry.getKey();
            List<Entity_B[]> value = (List<Entity_B[]>) entry.getValue();
            builder.append(key.toString() + " - " + Arrays.deepToString(value.toArray()));
        }
        builder.append("\n}");
        return builder.toString();
    }

    public static void main(String[] args) {
        Entity_B[] eB1 = new Entity_B[]{new Entity_B(new String[][]{{"A", "B"}, {"C", "D"}}, new double[]{1.0D, 2.0D, 3.0D}),
                new Entity_B(new String[][]{{"E", "F"}, {"G", "Y"}}, new double[]{4.0D, 5.0D, 6.0D})};
        Entity_B[] eB2 = new Entity_B[]{new Entity_B(new String[][]{{"A", "B"}, {"C", "D"}}, new double[]{1.0D, 2.0D, 3.0D}),
                new Entity_B(new String[][]{{"E", "F"}, {"G", "Y"}}, new double[]{4.0D, 5.0D, 6.0D})};
        Set<Entity_A> set = new HashSet<>();
        set.add(new Entity_A());
        Map<Set<Entity_A>, List<Entity_B[]>> map = new HashMap<>();
        map.put(set, Arrays.asList(eB1, eB2));

        Entity_C entity_c;
        entity_c = new Entity_C(new Entity_A(),
                Arrays.asList(new Entity_B(new String[][]{{"E", "F"}, {"G", "Y"}}, new double[]{4.0D, 5.0D, 6.0D})),
                map);
        System.out.println(entity_c.toString());
    }
}
