package sol;

import src.ITreeNode;
import src.Row;

import java.util.List;

/**
 * A class that represents the edge of a decision tree
 */
public class ValueEdge {
    // TODO: add more fields if needed
    private ITreeNode child;

    //added
    private List<Row> attrRows;
    private String attrType;
    private AttributeNode parent;

    public ValueEdge(ITreeNode next, List<Row> attrs, String attr) {
        this.child = next;
        this.attrRows = attrs;
        this.attrType = attr;


    }




}
