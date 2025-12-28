## Enterprise Request Approval Workflow

You are building an internal approval system for a large organization. Any employee can submit a request (e.g., expense reimbursement, leave approval, hardware purchase), and the request must be evaluated by multiple approvers in sequence. 

Each approver has limited authority and can either:
1. Approve the request 
2. Reject the request 
3. Forward it to the next level for further evaluation

### Context

Approval hierarchy (example):

1. Team Lead - Can approve requests up to ₹10,000 
2. Engineering Manager - Can approve requests up to ₹50,000 
3. Director - Can approve requests up to ₹2,00,000 
4. Finance Department - Final authority for higher amounts or policy checks. Rejects the reimbursement if the amount is more than ₹5,00,000

The exact approval path depends on the request amount and type.

### Functional Requirements

1. Request Object contains:
   1. Request type (EXPENSE, LEAVE, PURCHASE)
   2. Amount
   3. Employee Details
2. Each handler:
   1. Knows only its own responsibility 
   2. Decides whether it can handle the request 
   3. Otherwise forwards the request to the next handler

3. Dynamic Chain : 
   1. The approval chain must be configurable at runtime. 
   2. You should be able to add a new approval level or remove an approval level without changing existing handler logic.

4. Single Entry Point 
   1. The client submits the request only once. 
   2. The request automatically flows through the chain until:
      1. It is handled, or 
      2. It is rejected, or 
      3. The chain ends.