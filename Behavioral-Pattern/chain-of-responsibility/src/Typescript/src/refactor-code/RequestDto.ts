import TrainingEvaluation from "../legacy-code/TraniningEvaluation";
import TrainingEffectiveness from "../legacy-code/TrainningEffectiveness";
import IEntity from "../legacy-code/IEntity";


/**
 * RequestDto class contains all data that is required by the handler
 * 
 */
export default class RequestDto {

    code: String = "";
    isApproved: boolean = false;
    evaluation: TrainingEvaluation = {} as TrainingEvaluation;
    effectiveness: TrainingEffectiveness = {} as TrainingEffectiveness;
    hasEffectiveness: boolean = false;
    criteriaHasEvaluation: boolean = false;
    isNew: boolean = false;

    constructor(code: String, approve: boolean, evaluations: TrainingEvaluation[], effectiveness: TrainingEffectiveness[]) {
        this.evaluation = evaluations.filter(x => x.employeeCode == code.split('_')[0] && x.criteriaCode == code.split('_')[1])[0];
        this.effectiveness = effectiveness.filter(x => x.employeeCode == code.split('_')[0])[0];

        this.criteriaHasEvaluation = this.evaluation !== null;
        this.isNew = code.split('_')[1] == IEntity.newCode;
        this.hasEffectiveness = effectiveness != null;
        this.isApproved = approve;
    }
}
