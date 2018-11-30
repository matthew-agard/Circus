package com.appdev.matthewa.circus;

import android.app.Application;
import android.os.AsyncTask;

public class CircusRepository {
    private ActDAO mActDAO;
    private CustomerDAO mCustomerDAO;
    private ManagerDAO mManagerDAO;
    private PayrollDAO mPayrollDAO;
    private PerformerDAO mPerformerDAO;
    private RevenueDAO mRevenueDAO;
    private ReviewDAO mReviewDAO;
    private ScheduleDAO mScheduleDAO;
    private VotesDAO mVotesDAO;

    public CircusRepository(Application application) {
        CircusDatabase db = CircusDatabase.getDatabase(application);
        mActDAO = db.actDAO();
        mCustomerDAO = db.customerDAO();
        mManagerDAO = db.managerDAO();
        mPayrollDAO = db.payrollDAO();
        mPerformerDAO = db.performerDAO();
        mRevenueDAO = db.revenueDAO();
        mReviewDAO = db.reviewDAO();
        mScheduleDAO = db.scheduleDAO();
        mVotesDAO = db.votesDAO();
    }



}
