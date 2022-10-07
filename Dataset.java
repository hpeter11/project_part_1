package sol;

import src.DecisionTreeCSVParser;
import src.IDataset;
import src.ITreeNode;
import src.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that implements the IDataset interface,
 * representing a training data set.
 */
public class Dataset implements IDataset {
    // TODO: Implement methods declared in IDataset interface!

    private List<String> attributes;
    private List<Row> data;

    public Dataset(List<String> attributeList, List<Row> dataObjects) {
        // TODO: implement the constructor!
        this.attributes = attributeList;
        this.data = dataObjects;
    }

    //added
    public Dataset buildDataset(String CSVName, String targetAttribute) {
        String TRAINING_PATH = CSVName; // TODO: replace with your own input file
        String TARGET_ATTRIBUTE = targetAttribute;

        List<Row> dataObjects = DecisionTreeCSVParser.parse(TRAINING_PATH);
        List<String> attributeList = new ArrayList<>(dataObjects.get(0).getAttributes());

        Dataset myDataset = new Dataset(attributeList, dataObjects);
        return myDataset;
    }
    public List<String> getAttributes() {
        return this.attributes;
    }

    public List<Row> getData() {
        return this.data;
    }

    public int listLength() {
        int count = 0;
        for (String s : this.attributes) {
            count = count + 1;
        }
        return count;
    }

    public String randomAttribute() {
        Random random = new Random();
        int upperBound = this.listLength();
        int randomNum = random.nextInt(upperBound - 1);
        return this.attributes.get(randomNum - 1);
    }

    public Dataset refilter(String target) {
        int count = 0;
        ArrayList<String> l = new ArrayList<>();
        String t = null;
        for (String s : this.attributes) {
            if (s != target) {
                l.set(count, s);
                count++;
            } else {
                t = s;
            }
            count = count + 1;
            l.set(count, t);
        }
        Dataset x = new Dataset(l, this.data);
        return x;
    }

    public Dataset filterRows(String attribute, String type) {
        ArrayList<Row> l = new ArrayList<>();
        int count = 0;
        for (Row r : this.data) {
            if (r.getAttributeValue(attribute) == type) {
                l.add(count, r);
                count++;
            }
        }
        Dataset d = new Dataset(this.attributes, l);
        return d;
    }

}
