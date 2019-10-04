


export default class Label {
    
    value: String = "";

    constructor(result: String) {
        this.value = result;
    }

    public static approvedOn = () => {
        return new Label("approvedOn");
    }

    public static approvedOff = () => {
        return new Label("approvedOff");
    }

    public static reprovedOn  = () => {
        return new Label("reprovedOn");
    }

    public static reprovedOff = () => {
        return new Label("reprovedOff");
    }

}