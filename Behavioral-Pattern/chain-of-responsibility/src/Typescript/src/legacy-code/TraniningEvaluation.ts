

export default class TrainingEvaluation {

    hasEvaluation: boolean = false;
    employeeCode: String = "";
    criteriaCode: String = "";
    isApproved: boolean = false;

    constructor(hasEvaluation: boolean, employeeCode: String, criteriaCode: String, isApproved: boolean) {
        this.hasEvaluation = hasEvaluation;
        this.employeeCode = employeeCode;
        this.criteriaCode = criteriaCode;
        this.isApproved = isApproved;
    }
}
