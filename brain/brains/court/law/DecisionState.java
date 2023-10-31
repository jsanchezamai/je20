package brains.court.law;

public enum DecisionState {
    Requested,
    Started,
    InProgress,
    Done,
    Failed,
    Retrying,
    Abandon, Empty, WaitingForAck, WaitingForAck_PingArrived, WaitingForAck_AckSent, Rejected, WaitingForAck_AckSentRejected
}
