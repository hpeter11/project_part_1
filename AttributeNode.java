package sol;

import src.ITreeNode;
import src.Row;

import javax.management.Attribute;
import java.util.List;

/**
 * An inner node in the decision tree
 */
public class AttributeNode implements ITreeNode {
    // TODO: add more fields as needed
    private List<ValueEdge> outgoingEdges;

    //added
    private String attr;
    private Dataset d;
    private ValueEdge prev;
    private String attrDefault;

    public AttributeNode(List<ValueEdge> pointers, String attribute, Dataset data, ValueEdge last, String def) {
        this.outgoingEdges = pointers;
        this.attr = attribute;
        this.d = data;
        this.prev = last;
        this.attrDefault = def;
    }

    // TODO: implement the ITreeNode interface

    public ITreeNode nextNode(String attribute) {
        int attributeCounter = 0;
        String intialAttribute = this.data.get(0).getAttributeValue(attribute);
        for (Row r : this.data) {
            if (r.getAttributeValue(attribute) == intialAttribute) {
                attributeCounter++;
            }
        }
        if (attributeCounter == this.data.size()) {
            String s = null;
            s = this.data.get(0).getAttributeValue(attribute);
            DecisionLeaf d = new DecisionLeaf(s);
            ValueEdge v = new ValueEdge();
        }

        for (String a : this.attributes) {

        }
    }

}
