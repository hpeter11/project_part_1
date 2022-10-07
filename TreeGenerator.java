package sol;

import src.ITreeGenerator;
import src.ITreeNode;
import src.Row;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that implements the ITreeGenerator interface
 * used to generate a tree
 */
public class TreeGenerator implements ITreeGenerator<Dataset> {
    // TODO: document this field
    private ITreeNode top;

    //added

    public ArrayList<Row> FilterList(ArrayList<Row> l, String keyAttr, String thisAttr) {
        ArrayList<Row> x = new ArrayList<>();
        Integer count = 0;
        for (Row i : l) {
            if (i.getAttributeValue(keyAttr).equals(thisAttr)) {
                x.add(count, i);
                count = count + 1;
            }
        }
        return x;
    }

    /**
     *
     * Returns either a leaf if there is only one possible set of target
     * attributes and otherwise creates a node based on whichever attribute has
     * the most remaining rows
     *
     * @return
     */

    //TODO write create node in edge, create edge in node

    public void generateTree(Dataset trainingData, String targetAttribute) {
        if (trainingData.getAttributes() == null || trainingData.getData() == null) {
            this.top = null;
        // lists empty else if () {
        } else {
            Dataset d = trainingData.refilter(targetAttribute);
            String s = null;
            s = d.randomAttribute();
            this.top = trainingData.nextNode(targetAttribute);
        }
    }

    public String getDecision(Row datum) {
        return null;

    }


    // TODO: Implement methods declared in ITreeGenerator interface!
}
