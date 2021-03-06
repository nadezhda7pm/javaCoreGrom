package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
////                if channelName not equal  - compare it
////                if channelName is equal - check fingerprint
////                if fingerprint not equal  - compare it
////                if fingerprint is equal - check dateCreated
////                if dateCreated not equal  - compare it
////                if dateCreated is equal - objects are equal

    DateComparator dateComparator = new DateComparator();

    @Override
    public int compare(Capability o1, Capability o2) {
        System.out.println("FullComparator is used");

        if (compareNullsLast( o1.getChannelName(), o2.getChannelName()) != 100)
            return compareNullsLast(o1.getChannelName(), o2.getChannelName());
        else if (compareNullsLast(o1.getFingerprint(), o2.getFingerprint()) != 100)
            return compareNullsLast(o1.getFingerprint(), o2.getFingerprint());
        else return dateComparator.compare(o1, o2);
    }

    private int compareNullsLast(String o1, String o2) {
        if (o1 == null && o2 != null)
            return 1;
        else if (o1 != null && o2 == null)
            return -1;
        else if (o1 == null && o2 == null)
            return 0;
        else if (o1 != null && o2 != null && !o1.equals(o2))
            return o1.compareTo(o2);
        else return 100;
    }
}
