package sol;

import src.ITreeNode;
import src.Row;

/**
 * A class representing a leaf in the decision tree.
 */
public class DecisionLeaf implements ITreeNode {
    // TODO: add fields as needed

    //added
    private String decision;

    public DecisionLeaf(String d) {
        this.decision = d;
    }

    // TODO: Implement the ITreeNode interface
}
