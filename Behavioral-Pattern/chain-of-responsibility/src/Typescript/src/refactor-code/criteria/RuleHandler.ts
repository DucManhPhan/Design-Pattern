import RequestDto from "../RequestDto";
import Label from "../Label";



export default class RuleHandler {

    // @ts-ignore
    _nextHandler: RuleHandler = null;

    public handle(request: RequestDto): Label {
        return this._nextHandler.handle(request);
    }

    public setNext(ruleHandler: RuleHandler): RuleHandler {
        this._nextHandler = ruleHandler;
        return ruleHandler;
    }

}
