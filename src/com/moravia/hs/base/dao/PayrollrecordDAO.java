package com.moravia.hs.base.dao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.moravia.hs.base.entity.Emp;
import com.moravia.hs.base.entity.Payrollrecord;
import com.moravia.hs.base.entity.other.FinancialStatement_ByDepartOrCostCenter;
import com.moravia.hs.base.entity.other.FinancialStatement_SumSeason;
import com.moravia.hs.base.entity.other.TsSumDiffTime;

/**
 * A data access object (DAO) providing persistence and search support for
 * Payrollrecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.moravia.hs.base.entity.Payrollrecord
 * @author MyEclipse Persistence Tools
 */

public class PayrollrecordDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(PayrollrecordDAO.class);
	// property constants
	public static final String BASE_SALARY = "baseSalary";
	public static final String QUART_BONUS = "quartBonus";
	public static final String POST_ALLOWANCE = "postAllowance";
	public static final String TRANSPORT_ALLOWANCE = "transportAllowance";
	public static final String BONUS = "bonus";
	public static final String MEAL_SUBSIDY = "mealSubsidy";
	public static final String TOTAL_WORK_TIME = "totalWorkTime";
	public static final String OVERTIME = "overtime";
	public static final String OVERTIME_PAY = "overtimePay";
	public static final String PENSION_PERSONAL = "pensionPersonal";
	public static final String PENSION_COMPANY = "pensionCompany";
	public static final String MEDICAL_PERSONAL = "medicalPersonal";
	public static final String MEDICAL_COMPANY = "medicalCompany";
	public static final String ACCUM_FUND_PERSONAL = "accumFundPersonal";
	public static final String ACCUM_FUND_COMPANY = "accumFundCompany";
	public static final String UNEMP_INSU_PERSONAL = "unempInsuPersonal";
	public static final String UNEMP_INSU_COMPANY = "unempInsuCompany";
	public static final String INCOME_TAX = "incomeTax";
	public static final String OCCUP_INJURE_MATERNITY = "occupInjureMaternity";
	public static final String OTHER_PAY = "otherPay";
	public static final String PAYROLL_NOTE = "payrollNote";

	public void save(Payrollrecord transientInstance) {
		log.debug("saving Payrollrecord instance");
		try {
			getHibernateTemplate().save(transientInstance);
			getHibernateTemplate().flush();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Payrollrecord persistentInstance) {
		log.debug("deleting Payrollrecord instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Payrollrecord findById(java.lang.Integer id) {
		log.debug("getting Payrollrecord instance with id: " + id);
		try {
			Payrollrecord instance = (Payrollrecord) getHibernateTemplate().get(
					"com.moravia.hs.base.entity.Payrollrecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	/**
	 * Find All month by emp
	 * @return
	 */
	public List<Integer> findAllMonthByEmp(String emploginId) {
		try {
			log.debug("getting all months by emp");
			String queryString = "select month from Payrollrecord where emp_emploginid = ? order by month desc";
			return getHibernateTemplate().find(queryString, emploginId);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	/**
	 * Find Payroll by emp
	 * @param emploingId
	 * @return
	 */
	public List findByEmpAndMonth(String emploingId, Integer month) {
		try {
			log.debug("getting Payrollrecord by emp");
			String queryString = "from Payrollrecord where emp_emploginid = ? and month = ?";
			return getHibernateTemplate().find(queryString, emploingId, month);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	
	// Find unique payroll record by emp and Date
	public Payrollrecord findByEmpAndDate(String empLoginId, String startDate, String endDate) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "from Payrollrecord where emp_emploginid = ? and startDate = ? and endDate = ? order by createDate desc";
			Query queryObject = session.createQuery(queryString);
			queryObject.setString(0, empLoginId);
			queryObject.setString(1, startDate);
			queryObject.setString(2, endDate);
			
			
			if(queryObject.list().size() != 0) {
//				System.out.println("queryObject.list().size(): " + queryObject.list().size());
				return (Payrollrecord) queryObject.list().get(0);
			} else {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	// Find payroll by emp and Date
		public List<Payrollrecord> findAllByDate(String startDate, String endDate) {
			log.debug("finding all Payrollrecord instances");
			Session session = getHibernateTemplate().getSessionFactory().openSession();
			try {
				String queryString = "from Payrollrecord where startDate >= ? and endDate <= ? order by createDate";
				Query queryObject = session.createQuery(queryString);
				queryObject.setString(0, startDate);
				queryObject.setString(1, endDate);
				
				
				if(queryObject.list().size() != 0) {
//					System.out.println("queryObject.list().size(): " + queryObject.list().size());
					return queryObject.list();
				} else {
					return null;
				}
			} catch (RuntimeException re) {
				log.error("find all failed", re);
				throw re;
			}
		}
	
	//filter sum cost by department
	@Deprecated
	public List<FinancialStatement_SumSeason> findFinancialStatementFilterByDepartment(String startDate, String endDate) throws ParseException {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString =
					"SELECT\n" +
							"	tabE.depart_id,\n" +
							"	tabE.depart_name,\n" +
							"	sum(tabE.emp_month_sum) AS depart_session_sum\n" +
							"FROM\n" +
							"	(\n" +
							"		SELECT\n" +
							"			tabC.payroll_id,\n" +
							"			tabc.emp_id,\n" +
							"			tabD.emp_loginid,\n" +
							"			tabc. MONTH,\n" +
							"			tabC.startDate,\n" +
							"			tabC.enddate,\n" +
							"			(\n" +
							"				tabC.Base_Salary + tabC.Quart_Bonus + tabC.Post_Allowance + tabC.Transport_Allowance + \n" +
							"				tabC.Bonus + tabC.Meal_Subsidy + tabC.Overtime_Pay + tabC.Pension_Company + tabC.Medical_Company + \n" +
							"				tabC.Accum_Fund_Company + tabC.Unemp_Insu_Company + tabC.OccupInjure_Maternity + tabC.Other_Pay\n" +
							"			) AS emp_month_sum,\n" +
							"			tabD.depart_id,\n" +
							"			tabD.depart_name\n" +
							"		FROM\n" +
							"			(\n" +
							"				SELECT\n" +
							"					*\n" +
							"				FROM\n" +
							"					payrollrecord\n" +
							"				WHERE\n" +
							"					StartDate >= '" + startDate + "'\n" +
							"				AND EndDate <= '" + endDate + "'\n" +
							"			) AS tabC\n" +
							"		LEFT JOIN (\n" +
							"			SELECT\n" +
							"				emp_id,\n" +
							"				emp_loginid,\n" +
							"				depart_id,\n" +
							"				depart_name\n" +
							"			FROM\n" +
							"				(\n" +
							"					SELECT\n" +
							"						Emp_ID,\n" +
							"						Emp_LoginID,\n" +
							"						Department\n" +
							"					FROM\n" +
							"						emp\n" +
							"				) AS tabA\n" +
							"			LEFT JOIN (\n" +
							"				SELECT\n" +
							"					Depart_ID,\n" +
							"					Depart_Name\n" +
							"				FROM\n" +
							"					department\n" +
							"			) AS tabB ON tabA.department = tabB.depart_id\n" +
							"		) AS tabD ON tabC.emp_id = tabD.emp_id\n" +
							"	) AS tabE\n" +
							"GROUP BY\n" +
							"	tabE.depart_id"; 
			
			SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("depart_id", Hibernate.INTEGER).addScalar("depart_name", Hibernate.STRING)
					.addScalar("depart_session_sum", Hibernate.DOUBLE);
			
			Iterator it = sqlquery.list().iterator();
			FinancialStatement_SumSeason fss = null;
			List<FinancialStatement_SumSeason> fss_list = new ArrayList<FinancialStatement_SumSeason>();
			// cast and round, keep 2 decimal
			DecimalFormat df = new DecimalFormat("#.00");
			
			while(it.hasNext()) {
				fss = new FinancialStatement_SumSeason();
				Object[] rows = (Object[]) it.next();
//				Integer id = (Integer) rows[0];
				String depart_name = (String) rows[1];
				Double depart_session_sum = (Double) rows[2]; 
				fss.setDepartName(depart_name);
				fss.setCostSum(Double.parseDouble(df.format(depart_session_sum)));
				fss_list.add(fss);
			}
			return fss_list;
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		} finally {
//			log.debug("closing session");
			session.close();
		}
	}
	
	
	
	//filter sum cost by department v2
		@Deprecated	
		public List<FinancialStatement_ByDepartOrCostCenter> findFinancialStatementFilterByDepartOrCostCenter(String sectionName, String startDate, String endDate) throws ParseException {
			Session session = getHibernateTemplate().getSessionFactory().openSession();
			try {
				String queryString =
						"SELECT\n" +
								"	sum(tab_F.Bonus) AS bonus,\n" +
								"	sum(tab_F.base_salary) monthlyBaseSalary,\n" +
								"	sum(tab_F.Other_Pay) adjustment,\n" +
								"	sum(tab_F.quart_bonus) quartBonus,\n" +
								"	sum(tab_F.Overtime_Pay) OvertimePay,\n" +
								"	sum(tab_F.Meal_Subsidy) MealSubsidy,\n" +
								"	sum(tab_F.Transport_Allowance) TransAllowance,\n" +
								"	sum(\n" +
								"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance\n" +
								"	) SalaryInPayroll,\n" +
								"	sum(\n" +
								"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance - tab_F.Medical_Personal - tab_F.Pension_Personal - tab_F.Accum_Fund_Personal - tab_F.Unemp_Insu_Personal - tab_F.Income_Tax\n" +
								"	) netSalary,\n" +
								"	sum(tab_F.Medical_Personal) medicalPersonal,\n" +
								"	sum(tab_F.Medical_Company) medicalCompany,\n" +
								"	sum(\n" +
								"		tab_F.Pension_Personal + tab_F.Unemp_Insu_Personal\n" +
								"	) socialInsPersonal,\n" +
								"	sum(\n" +
								"		tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity\n" +
								"	) socialInsCompany,\n" +
								"	sum(tab_F.Income_Tax) tax,\n" +
								"	sum(tab_F.Accum_Fund_Personal) housingFundPersonal,\n" +
								"	sum(tab_F.Accum_Fund_Company) housingFundCompany,\n" +
								"	sum(\n" +
								"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company\n" +
								"	) payrollTotal,\n" +
								"	sum(tab_F.mbo_monthlyportion) mboMonthlyPortion,\n" +
								"	sum(\n" +
								"		tab_F.annualbonus_monthlyportion\n" +
								"	) annualBonusMonthlyPortion,\n" +
								"   sum(tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company + tab_F.mbo_monthlyportion + tab_F.annualbonus_monthlyportion) total, " +
								"	tab_F." + sectionName +"\n" +
								"FROM\n" +
								"	(\n" +
								"		SELECT\n" +
								"			tab_E.payroll_id,\n" +
								"			tab_E.emp_id,\n" +
								"			tab_E. MONTH,\n" +
								"			tab_E.startDate,\n" +
								"			tab_E.endDate,\n" +
								"			tab_E.base_salary,\n" +
								"			tab_E.quart_bonus,\n" +
								"			tab_E.Post_Allowance,\n" +
								"			tab_E.Transport_Allowance,\n" +
								"			tab_E.Bonus,\n" +
								"			tab_E.Meal_Subsidy,\n" +
								"			tab_E.Overtime_Pay,\n" +
								"			tab_E.Pension_Personal,\n" +
								"			tab_E.Pension_Company,\n" +
								"			tab_E.Medical_Personal,\n" +
								"			tab_E.Medical_Company,\n" +
								"			tab_E.Accum_Fund_Personal,\n" +
								"			tab_E.Accum_Fund_Company,\n" +
								"			tab_E.Unemp_Insu_Personal,\n" +
								"			tab_E.Unemp_Insu_Company,\n" +
								"			tab_E.Income_Tax,\n" +
								"			tab_E.OccupInjure_Maternity,\n" +
								"			tab_E.Other_Pay,\n" +
								"			tab_E.mbo_monthlyportion,\n" +
								"			tab_E.annualbonus_monthlyportion,\n" +
								"			tab_D.emp_loginid,\n" +
								"			tab_D.depart_id,\n" +
								"			tab_D.depart_name,\n" +
								"			tab_D.cost_center_id,\n" +
								"			tab_D.cost_center_name\n" +
								"		FROM\n" +
								"			(SELECT * FROM payrollrecord WHERE\n" +
								"	StartDate >= '" + startDate + "'\n" +
								"	AND EndDate <= '" + endDate + "'\n" +
								"		)	AS tab_E\n" +
								"		LEFT JOIN (\n" +
								"			SELECT\n" +
								"				emp_id,\n" +
								"				emp_loginid,\n" +
								"				depart_id,\n" +
								"				depart_name,\n" +
								"				cost_center_id,\n" +
								"				cost_center_name\n" +
								"			FROM\n" +
								"				(\n" +
								"					SELECT\n" +
								"						Emp_ID,\n" +
								"						Emp_LoginID,\n" +
								"						Department,\n" +
								"						Cost_Center\n" +
								"					FROM\n" +
								"						emp\n" +
								"				) AS tab_A\n" +
								"			LEFT JOIN (\n" +
								"				SELECT\n" +
								"					Depart_ID,\n" +
								"					Depart_Name\n" +
								"				FROM\n" +
								"					department\n" +
								"			) AS tab_B ON tab_A.department = tab_B.depart_id\n" +
								"			LEFT JOIN (\n" +
								"				SELECT\n" +
								"					Cost_Center_ID,\n" +
								"					Cost_Center_Name\n" +
								"				FROM\n" +
								"					costcenter\n" +
								"			) AS tab_C ON tab_A.Cost_Center = tab_C.Cost_Center_ID\n" +
								"			ORDER BY\n" +
								"				emp_id\n" +
								"		) AS tab_D ON tab_D.emp_id = tab_E.emp_id\n" +
								"	) AS tab_F\n" +
								"GROUP BY\n" +
								"	tab_F." + sectionName;
				
				SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("bonus", Hibernate.DOUBLE).addScalar("monthlyBaseSalary", Hibernate.DOUBLE)
						.addScalar("adjustment", Hibernate.DOUBLE).addScalar("quartBonus", Hibernate.DOUBLE).addScalar("OvertimePay", Hibernate.DOUBLE)
						.addScalar("MealSubsidy", Hibernate.DOUBLE).addScalar("TransAllowance", Hibernate.DOUBLE).addScalar("SalaryInPayroll", Hibernate.DOUBLE)
						.addScalar("netSalary", Hibernate.DOUBLE).addScalar("medicalPersonal", Hibernate.DOUBLE).addScalar("medicalCompany", Hibernate.DOUBLE)
						.addScalar("socialInsPersonal", Hibernate.DOUBLE).addScalar("socialInsCompany", Hibernate.DOUBLE).addScalar("tax", Hibernate.DOUBLE)
						.addScalar("housingFundPersonal", Hibernate.DOUBLE).addScalar("housingFundCompany", Hibernate.DOUBLE).addScalar("payrollTotal", Hibernate.DOUBLE)
						.addScalar("mboMonthlyPortion", Hibernate.DOUBLE).addScalar("annualBonusMonthlyPortion", Hibernate.DOUBLE).addScalar("total", Hibernate.DOUBLE).addScalar(sectionName, Hibernate.STRING);
				
				Iterator it = sqlquery.list().iterator();
				FinancialStatement_ByDepartOrCostCenter fsdoc = null;
				List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list = new ArrayList<FinancialStatement_ByDepartOrCostCenter>();
				// cast and round, keep 2 decimal
				DecimalFormat df = new DecimalFormat("#.00");
				
				while(it.hasNext()) {
					fsdoc = new FinancialStatement_ByDepartOrCostCenter();
					
					Object[] rows = (Object[]) it.next();
					Double bonus = (Double) rows[0];
					Double monthlyBaseSalary = (Double) rows[1];
					Double adjustment = (Double) rows[2];
					Double quartBonus = (Double) rows[3];
					Double OvertimePay = (Double) rows[4];
					Double MealSubsidy = (Double) rows[5];
					Double TransAllowance = (Double) rows[6];
					Double SalaryInPayroll = (Double) rows[7];
					Double netSalary = (Double) rows[8];
					Double medicalPersonal = (Double) rows[9];
					Double medicalCompany = (Double) rows[10];
					Double socialInsPersonal = (Double) rows[11];
					Double socialInsCompany = (Double) rows[12];
					Double tax = (Double) rows[13];
					Double housingFundPersonal = (Double) rows[14];
					Double housingFundCompany = (Double) rows[15];
					Double payrollTotal = (Double) rows[16];
					Double mboMonthlyPortion = (Double) rows[17];
					Double annualBonusMonthlyPortion = (Double) rows[18];
					Double total = (Double) rows[19];
					String section_name = (String) rows[20];
					
					fsdoc.setBonus(Double.parseDouble(df.format(bonus)));
					fsdoc.setMonthlyBaseSalary(Double.parseDouble(df.format(monthlyBaseSalary)));
					fsdoc.setAdjustment(Double.parseDouble(df.format(adjustment)));
					fsdoc.setQuartBonus(Double.parseDouble(df.format(quartBonus)));
					fsdoc.setOvertimePay(Double.parseDouble(df.format(OvertimePay)));
					fsdoc.setMealSubsidy(Double.parseDouble(df.format(MealSubsidy)));
					fsdoc.setTransAllowance(Double.parseDouble(df.format(TransAllowance)));
					fsdoc.setSalaryInPayroll(Double.parseDouble(df.format(SalaryInPayroll)));
					fsdoc.setNetSalary(Double.parseDouble(df.format(netSalary)));
					fsdoc.setMedicalPersonal(Double.parseDouble(df.format(medicalPersonal)));
					fsdoc.setMedicalCompany(Double.parseDouble(df.format(medicalCompany)));
					fsdoc.setSocialInsPersonal(Double.parseDouble(df.format(socialInsPersonal)));
					fsdoc.setSocialInsCompany(Double.parseDouble(df.format(socialInsCompany)));
					fsdoc.setTax(Double.parseDouble(df.format(tax)));
					fsdoc.setHousingFundPersonal(Double.parseDouble(df.format(housingFundPersonal)));
					fsdoc.setHousingFundCompany(Double.parseDouble(df.format(housingFundCompany)));
					fsdoc.setPayrollTotal(Double.parseDouble(df.format(payrollTotal)));
					fsdoc.setMboMonthlyPortion(Double.parseDouble(df.format(mboMonthlyPortion)));
					fsdoc.setAnnualBonusMonthlyPortion(Double.parseDouble(df.format(annualBonusMonthlyPortion)));
					fsdoc.setTotal(Double.parseDouble(df.format(total)));
					fsdoc.setSection_name(section_name);

					fsdoc_list.add(fsdoc);
				}
				return fsdoc_list;
			} catch (RuntimeException re) {
//				log.error("find all failed", re);
				throw re;
			} finally {
//				log.debug("closing session");
				session.close();
			}
		}
	
		//version 2
		public List<FinancialStatement_ByDepartOrCostCenter> findFinancialStatementFilterByDepartOrCostCenter2(String sectionName, String startDate, String endDate) throws ParseException {
			Session session = getHibernateTemplate().getSessionFactory().openSession();
			System.out.println("Running findFinancialStatementFilterByDepartOrCostCenter2....");
			try {
				String queryString =
						"SELECT\n" +
								"	sum(tab_F.Bonus) AS bonus,\n" +
								"	sum(tab_F.base_salary) monthlyBaseSalary,\n" +
								"	sum(tab_F.Other_Pay) adjustment,\n" +
								"	sum(tab_F.quart_bonus) quartBonus,\n" +
								"	sum(tab_F.Overtime_Pay) OvertimePay,\n" +
								"	sum(tab_F.Meal_Subsidy) MealSubsidy,\n" +
								"	sum(tab_F.Transport_Allowance) TransAllowance,\n" +
								"	sum(\n" +
								"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.post_allowance\n" +
								"	) SalaryInPayroll,\n" +
								"	sum(\n" +
								"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.post_allowance - tab_F.Medical_Personal - tab_F.Pension_Personal - tab_F.Accum_Fund_Personal - tab_F.Unemp_Insu_Personal - tab_F.Income_Tax\n" +
								"	) netSalary,\n" +
								"	sum(tab_F.Medical_Personal) medicalPersonal,\n" +
								"	sum(tab_F.Medical_Company) medicalCompany,\n" +
								"	sum(\n" +
								"		tab_F.Pension_Personal + tab_F.Unemp_Insu_Personal\n" +
								"	) socialInsPersonal,\n" +
								"	sum(\n" +
								"		tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity\n" +
								"	) socialInsCompany,\n" +
								"	sum(tab_F.Income_Tax) tax,\n" +
								"	sum(tab_F.Accum_Fund_Personal) housingFundPersonal,\n" +
								"	sum(tab_F.Accum_Fund_Company) housingFundCompany,\n" +
								"	sum(\n" +
								"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.post_allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company\n" +
								"	) payrollTotal,\n" +
								"	sum(tab_F.mbo_monthlyportion) mboMonthlyPortion,\n" +
								"	sum(\n" +
								"		tab_F.annualbonus_monthlyportion\n" +
								"	) annualBonusMonthlyPortion,\n" +
								"	sum(\n" +
								"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.post_allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company + tab_F.mbo_monthlyportion + tab_F.annualbonus_monthlyportion\n" +
								"	) total,\n" +
								"	tab_F." + sectionName +"\n" +
								"FROM\n" +
								"(\n" +
								"	SELECT\n" +
								"		*\n" +
								"	FROM\n" +
								"		payrollrecord\n" +
								"	WHERE\n" +
								"		StartDate >= '" + startDate + "'\n" +
								"	AND EndDate <= '" + endDate + "'\n" +
								") AS tab_F\n" +
//								"GROUP BY\n" +
//								"tab_F.department_name\n" +
								"GROUP BY tab_F." + sectionName;
				
				SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("bonus", Hibernate.DOUBLE).addScalar("monthlyBaseSalary", Hibernate.DOUBLE)
						.addScalar("adjustment", Hibernate.DOUBLE).addScalar("quartBonus", Hibernate.DOUBLE).addScalar("OvertimePay", Hibernate.DOUBLE)
						.addScalar("MealSubsidy", Hibernate.DOUBLE).addScalar("TransAllowance", Hibernate.DOUBLE).addScalar("SalaryInPayroll", Hibernate.DOUBLE)
						.addScalar("netSalary", Hibernate.DOUBLE).addScalar("medicalPersonal", Hibernate.DOUBLE).addScalar("medicalCompany", Hibernate.DOUBLE)
						.addScalar("socialInsPersonal", Hibernate.DOUBLE).addScalar("socialInsCompany", Hibernate.DOUBLE).addScalar("tax", Hibernate.DOUBLE)
						.addScalar("housingFundPersonal", Hibernate.DOUBLE).addScalar("housingFundCompany", Hibernate.DOUBLE).addScalar("payrollTotal", Hibernate.DOUBLE)
						.addScalar("mboMonthlyPortion", Hibernate.DOUBLE).addScalar("annualBonusMonthlyPortion", Hibernate.DOUBLE).addScalar("total", Hibernate.DOUBLE).addScalar(sectionName, Hibernate.STRING);
				
				Iterator it = sqlquery.list().iterator();
				FinancialStatement_ByDepartOrCostCenter fsdoc = null;
				List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list = new ArrayList<FinancialStatement_ByDepartOrCostCenter>();
				// cast and round, keep 2 decimal
				DecimalFormat df = new DecimalFormat("#.00");
				
				while(it.hasNext()) {
					fsdoc = new FinancialStatement_ByDepartOrCostCenter();
					
					Object[] rows = (Object[]) it.next();
					Double bonus = (Double) rows[0];
					Double monthlyBaseSalary = (Double) rows[1];
					Double adjustment = (Double) rows[2];
					Double quartBonus = (Double) rows[3];
					Double OvertimePay = (Double) rows[4];
					Double MealSubsidy = (Double) rows[5];
					Double TransAllowance = (Double) rows[6];
					Double SalaryInPayroll = (Double) rows[7];
					Double netSalary = (Double) rows[8];
					Double medicalPersonal = (Double) rows[9];
					Double medicalCompany = (Double) rows[10];
					Double socialInsPersonal = (Double) rows[11];
					Double socialInsCompany = (Double) rows[12];
					Double tax = (Double) rows[13];
					Double housingFundPersonal = (Double) rows[14];
					Double housingFundCompany = (Double) rows[15];
					Double payrollTotal = (Double) rows[16];
					Double mboMonthlyPortion = (Double) rows[17];
					Double annualBonusMonthlyPortion = (Double) rows[18];
					Double total = (Double) rows[19];
					String section_name = (String) rows[20];
					
					fsdoc.setBonus(Double.parseDouble(df.format(bonus)));
					fsdoc.setMonthlyBaseSalary(Double.parseDouble(df.format(monthlyBaseSalary)));
					fsdoc.setAdjustment(Double.parseDouble(df.format(adjustment)));
					fsdoc.setQuartBonus(Double.parseDouble(df.format(quartBonus)));
					fsdoc.setOvertimePay(Double.parseDouble(df.format(OvertimePay)));
					fsdoc.setMealSubsidy(Double.parseDouble(df.format(MealSubsidy)));
					fsdoc.setTransAllowance(Double.parseDouble(df.format(TransAllowance)));
					fsdoc.setSalaryInPayroll(Double.parseDouble(df.format(SalaryInPayroll)));
					fsdoc.setNetSalary(Double.parseDouble(df.format(netSalary)));
					fsdoc.setMedicalPersonal(Double.parseDouble(df.format(medicalPersonal)));
					fsdoc.setMedicalCompany(Double.parseDouble(df.format(medicalCompany)));
					fsdoc.setSocialInsPersonal(Double.parseDouble(df.format(socialInsPersonal)));
					fsdoc.setSocialInsCompany(Double.parseDouble(df.format(socialInsCompany)));
					fsdoc.setTax(Double.parseDouble(df.format(tax)));
					fsdoc.setHousingFundPersonal(Double.parseDouble(df.format(housingFundPersonal)));
					fsdoc.setHousingFundCompany(Double.parseDouble(df.format(housingFundCompany)));
					fsdoc.setPayrollTotal(Double.parseDouble(df.format(payrollTotal)));
					fsdoc.setMboMonthlyPortion(Double.parseDouble(df.format(mboMonthlyPortion)));
					fsdoc.setAnnualBonusMonthlyPortion(Double.parseDouble(df.format(annualBonusMonthlyPortion)));
					fsdoc.setTotal(Double.parseDouble(df.format(total)));
					fsdoc.setSection_name(section_name);

					fsdoc_list.add(fsdoc);
				}
				return fsdoc_list;
			} catch (RuntimeException re) {
//				log.error("find all failed", re);
				throw re;
			} finally {
//				log.debug("closing session");
				session.close();
			}
		}
		
		
		
		//filter sum cost by department v2
		@Deprecated
			public List<FinancialStatement_ByDepartOrCostCenter> findFinancialStatementFilterByCustomized(String loginIds, String startDate, String endDate) throws ParseException {
				Session session = getHibernateTemplate().getSessionFactory().openSession();
				try {
					String queryString =
							"SELECT\n" +
									"	sum(tab_F.Bonus) AS bonus,\n" +
									"	sum(tab_F.base_salary) monthlyBaseSalary,\n" +
									"	sum(tab_F.Other_Pay) adjustment,\n" +
									"	sum(tab_F.quart_bonus) quartBonus,\n" +
									"	sum(tab_F.Overtime_Pay) OvertimePay,\n" +
									"	sum(tab_F.Meal_Subsidy) MealSubsidy,\n" +
									"	sum(tab_F.Transport_Allowance) TransAllowance,\n" +
									"	sum(\n" +
									"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance\n" +
									"	) SalaryInPayroll,\n" +
									"	sum(\n" +
									"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance - tab_F.Medical_Personal - tab_F.Pension_Personal - tab_F.Accum_Fund_Personal - tab_F.Unemp_Insu_Personal - tab_F.Income_Tax\n" +
									"	) netSalary,\n" +
									"	sum(tab_F.Medical_Personal) medicalPersonal,\n" +
									"	sum(tab_F.Medical_Company) medicalCompany,\n" +
									"	sum(\n" +
									"		tab_F.Pension_Personal + tab_F.Unemp_Insu_Personal\n" +
									"	) socialInsPersonal,\n" +
									"	sum(\n" +
									"		tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity\n" +
									"	) socialInsCompany,\n" +
									"	sum(tab_F.Income_Tax) tax,\n" +
									"	sum(tab_F.Accum_Fund_Personal) housingFundPersonal,\n" +
									"	sum(tab_F.Accum_Fund_Company) housingFundCompany,\n" +
									"	sum(\n" +
									"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company\n" +
									"	) payrollTotal,\n" +
									"	sum(tab_F.mbo_monthlyportion) mboMonthlyPortion,\n" +
									"	sum(\n" +
									"		tab_F.annualbonus_monthlyportion\n" +
									"	) annualBonusMonthlyPortion,\n" +
									"   sum(tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company + tab_F.mbo_monthlyportion + tab_F.annualbonus_monthlyportion) total, " +
									"	tab_F.emp_loginid\n" +
									"FROM\n" +
									"	(\n" +
									"select * from \n" +
									"(		\n" +
									"SELECT\n" +
									"			tab_E.payroll_id,\n" +
									"			tab_E.emp_id,\n" +
									"			tab_E. MONTH,\n" +
									"			tab_E.startDate,\n" +
									"			tab_E.endDate,\n" +
									"			tab_E.base_salary,\n" +
									"			tab_E.quart_bonus,\n" +
									"			tab_E.Post_Allowance,\n" +
									"			tab_E.Transport_Allowance,\n" +
									"			tab_E.Bonus,\n" +
									"			tab_E.Meal_Subsidy,\n" +
									"			tab_E.Overtime_Pay,\n" +
									"			tab_E.Pension_Personal,\n" +
									"			tab_E.Pension_Company,\n" +
									"			tab_E.Medical_Personal,\n" +
									"			tab_E.Medical_Company,\n" +
									"			tab_E.Accum_Fund_Personal,\n" +
									"			tab_E.Accum_Fund_Company,\n" +
									"			tab_E.Unemp_Insu_Personal,\n" +
									"			tab_E.Unemp_Insu_Company,\n" +
									"			tab_E.Income_Tax,\n" +
									"			tab_E.OccupInjure_Maternity,\n" +
									"			tab_E.Other_Pay,\n" +
									"			tab_E.mbo_monthlyportion,\n" +
									"			tab_E.annualbonus_monthlyportion,\n" +
									"			tab_D.emp_loginid,\n" +
									"			tab_D.depart_id,\n" +
									"			tab_D.depart_name,\n" +
									"			tab_D.cost_center_id,\n" +
									"			tab_D.cost_center_name\n" +
									"		FROM\n" +
									"			(SELECT * FROM payrollrecord WHERE\n" +
									"	StartDate >= '" + startDate + "'\n" +
									"	AND EndDate <= '" + endDate + "'\n" +
									"		)	AS tab_E\n" +
									"		LEFT JOIN (\n" +
									"			SELECT\n" +
									"				emp_id,\n" +
									"				emp_loginid,\n" +
									"				depart_id,\n" +
									"				depart_name,\n" +
									"				cost_center_id,\n" +
									"				cost_center_name\n" +
									"			FROM\n" +
									"				(\n" +
									"					SELECT\n" +
									"						Emp_ID,\n" +
									"						Emp_LoginID,\n" +
									"						Department,\n" +
									"						Cost_Center\n" +
									"					FROM\n" +
									"						emp\n" +
									"				) AS tab_A\n" +
									"			LEFT JOIN (\n" +
									"				SELECT\n" +
									"					Depart_ID,\n" +
									"					Depart_Name\n" +
									"				FROM\n" +
									"					department\n" +
									"			) AS tab_B ON tab_A.department = tab_B.depart_id\n" +
									"			LEFT JOIN (\n" +
									"				SELECT\n" +
									"					Cost_Center_ID,\n" +
									"					Cost_Center_Name\n" +
									"				FROM\n" +
									"					costcenter\n" +
									"			) AS tab_C ON tab_A.Cost_Center = tab_C.Cost_Center_ID\n" +
									"			ORDER BY\n" +
									"				emp_id\n" +
									"		) AS tab_D ON tab_D.emp_id = tab_E.emp_id\n" +
									"	) as tab_G\n" +
									"	where tab_G.emp_loginid in " + loginIds +
									"	)AS tab_F\n" +
									"GROUP BY\n" +
									"	tab_F.emp_loginid";
							
					
					SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("bonus", Hibernate.DOUBLE).addScalar("monthlyBaseSalary", Hibernate.DOUBLE)
							.addScalar("adjustment", Hibernate.DOUBLE).addScalar("quartBonus", Hibernate.DOUBLE).addScalar("OvertimePay", Hibernate.DOUBLE)
							.addScalar("MealSubsidy", Hibernate.DOUBLE).addScalar("TransAllowance", Hibernate.DOUBLE).addScalar("SalaryInPayroll", Hibernate.DOUBLE)
							.addScalar("netSalary", Hibernate.DOUBLE).addScalar("medicalPersonal", Hibernate.DOUBLE).addScalar("medicalCompany", Hibernate.DOUBLE)
							.addScalar("socialInsPersonal", Hibernate.DOUBLE).addScalar("socialInsCompany", Hibernate.DOUBLE).addScalar("tax", Hibernate.DOUBLE)
							.addScalar("housingFundPersonal", Hibernate.DOUBLE).addScalar("housingFundCompany", Hibernate.DOUBLE).addScalar("payrollTotal", Hibernate.DOUBLE)
							.addScalar("mboMonthlyPortion", Hibernate.DOUBLE).addScalar("annualBonusMonthlyPortion", Hibernate.DOUBLE).addScalar("total", Hibernate.DOUBLE).addScalar("emp_loginid", Hibernate.STRING);
					
					Iterator it = sqlquery.list().iterator();
					FinancialStatement_ByDepartOrCostCenter fsdoc = null;
					List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list = new ArrayList<FinancialStatement_ByDepartOrCostCenter>();
					// cast and round, keep 2 decimal
					DecimalFormat df = new DecimalFormat("#.00");
					
					while(it.hasNext()) {
						fsdoc = new FinancialStatement_ByDepartOrCostCenter();
						
						Object[] rows = (Object[]) it.next();
						Double bonus = (Double) rows[0];
						Double monthlyBaseSalary = (Double) rows[1];
						Double adjustment = (Double) rows[2];
						Double quartBonus = (Double) rows[3];
						Double OvertimePay = (Double) rows[4];
						Double MealSubsidy = (Double) rows[5];
						Double TransAllowance = (Double) rows[6];
						Double SalaryInPayroll = (Double) rows[7];
						Double netSalary = (Double) rows[8];
						Double medicalPersonal = (Double) rows[9];
						Double medicalCompany = (Double) rows[10];
						Double socialInsPersonal = (Double) rows[11];
						Double socialInsCompany = (Double) rows[12];
						Double tax = (Double) rows[13];
						Double housingFundPersonal = (Double) rows[14];
						Double housingFundCompany = (Double) rows[15];
						Double payrollTotal = (Double) rows[16];
						Double mboMonthlyPortion = (Double) rows[17];
						Double annualBonusMonthlyPortion = (Double) rows[18];
						Double total = (Double) rows[19];
						String emp_loginid = (String) rows[20];
						
						fsdoc.setBonus(Double.parseDouble(df.format(bonus)));
						fsdoc.setMonthlyBaseSalary(Double.parseDouble(df.format(monthlyBaseSalary)));
						fsdoc.setAdjustment(Double.parseDouble(df.format(adjustment)));
						fsdoc.setQuartBonus(Double.parseDouble(df.format(quartBonus)));
						fsdoc.setOvertimePay(Double.parseDouble(df.format(OvertimePay)));
						fsdoc.setMealSubsidy(Double.parseDouble(df.format(MealSubsidy)));
						fsdoc.setTransAllowance(Double.parseDouble(df.format(TransAllowance)));
						fsdoc.setSalaryInPayroll(Double.parseDouble(df.format(SalaryInPayroll)));
						fsdoc.setNetSalary(Double.parseDouble(df.format(netSalary)));
						fsdoc.setMedicalPersonal(Double.parseDouble(df.format(medicalPersonal)));
						fsdoc.setMedicalCompany(Double.parseDouble(df.format(medicalCompany)));
						fsdoc.setSocialInsPersonal(Double.parseDouble(df.format(socialInsPersonal)));
						fsdoc.setSocialInsCompany(Double.parseDouble(df.format(socialInsCompany)));
						fsdoc.setTax(Double.parseDouble(df.format(tax)));
						fsdoc.setHousingFundPersonal(Double.parseDouble(df.format(housingFundPersonal)));
						fsdoc.setHousingFundCompany(Double.parseDouble(df.format(housingFundCompany)));
						fsdoc.setPayrollTotal(Double.parseDouble(df.format(payrollTotal)));
						fsdoc.setMboMonthlyPortion(Double.parseDouble(df.format(mboMonthlyPortion)));
						fsdoc.setAnnualBonusMonthlyPortion(Double.parseDouble(df.format(annualBonusMonthlyPortion)));
						fsdoc.setTotal(Double.parseDouble(df.format(total)));
						fsdoc.setSection_name(emp_loginid);

						fsdoc_list.add(fsdoc);
					}
					return fsdoc_list;
				} catch (RuntimeException re) {
//						log.error("find all failed", re);
					throw re;
				} finally {
//						log.debug("closing session");
					session.close();
				}
			}
	
	
			public List<FinancialStatement_ByDepartOrCostCenter> findFinancialStatementFilterByCustomized2(String loginIds, String startDate, String endDate) throws ParseException {
				Session session = getHibernateTemplate().getSessionFactory().openSession();
				try {
					String queryString =
							"SELECT\n" +
									"	sum(tab_F.Bonus) AS bonus,\n" +
									"	sum(tab_F.base_salary) monthlyBaseSalary,\n" +
									"	sum(tab_F.Other_Pay) adjustment,\n" +
									"	sum(tab_F.quart_bonus) quartBonus,\n" +
									"	sum(tab_F.Overtime_Pay) OvertimePay,\n" +
									"	sum(tab_F.Meal_Subsidy) MealSubsidy,\n" +
									"	sum(tab_F.Transport_Allowance) TransAllowance,\n" +
									"	sum(\n" +
									"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance\n" +
									"	) SalaryInPayroll,\n" +
									"	sum(\n" +
									"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance - tab_F.Medical_Personal - tab_F.Pension_Personal - tab_F.Accum_Fund_Personal - tab_F.Unemp_Insu_Personal - tab_F.Income_Tax\n" +
									"	) netSalary,\n" +
									"	sum(tab_F.Medical_Personal) medicalPersonal,\n" +
									"	sum(tab_F.Medical_Company) medicalCompany,\n" +
									"	sum(\n" +
									"		tab_F.Pension_Personal + tab_F.Unemp_Insu_Personal\n" +
									"	) socialInsPersonal,\n" +
									"	sum(\n" +
									"		tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity\n" +
									"	) socialInsCompany,\n" +
									"	sum(tab_F.Income_Tax) tax,\n" +
									"	sum(tab_F.Accum_Fund_Personal) housingFundPersonal,\n" +
									"	sum(tab_F.Accum_Fund_Company) housingFundCompany,\n" +
									"	sum(\n" +
									"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company\n" +
									"	) payrollTotal,\n" +
									"	sum(tab_F.mbo_monthlyportion) mboMonthlyPortion,\n" +
									"	sum(\n" +
									"		tab_F.annualbonus_monthlyportion\n" +
									"	) annualBonusMonthlyPortion,\n" +
									"	sum(\n" +
									"		tab_F.Bonus + tab_F.base_salary + tab_F.Other_Pay + tab_F.quart_bonus + tab_F.Overtime_Pay + tab_F.Meal_Subsidy + tab_F.Transport_Allowance + tab_F.Medical_Company + tab_F.Pension_Company + tab_F.Unemp_Insu_Company + tab_F.OccupInjure_Maternity + tab_F.Accum_Fund_Company + tab_F.mbo_monthlyportion + tab_F.annualbonus_monthlyportion\n" +
									"	) total,\n" +
									"	tab_F.Emp_empLoginID\n" +
									"FROM\n" +
									"(\n" +
									"	SELECT\n" +
									"		*\n" +
									"	FROM\n" +
									"		payrollrecord\n" +
									"	WHERE\n" +
									"		StartDate >= '" + startDate + "'\n" +
									"	AND EndDate <= '" + endDate + "'\n" +
									"	AND Emp_empLoginID in  " + loginIds  +
									") AS tab_F\n" +
									"GROUP BY\n" +
									"tab_F.Emp_empLoginID\n" +
									"-- GROUP BY tab_F.Department_Name";
							
					
					SQLQuery sqlquery = session.createSQLQuery(queryString).addScalar("bonus", Hibernate.DOUBLE).addScalar("monthlyBaseSalary", Hibernate.DOUBLE)
							.addScalar("adjustment", Hibernate.DOUBLE).addScalar("quartBonus", Hibernate.DOUBLE).addScalar("OvertimePay", Hibernate.DOUBLE)
							.addScalar("MealSubsidy", Hibernate.DOUBLE).addScalar("TransAllowance", Hibernate.DOUBLE).addScalar("SalaryInPayroll", Hibernate.DOUBLE)
							.addScalar("netSalary", Hibernate.DOUBLE).addScalar("medicalPersonal", Hibernate.DOUBLE).addScalar("medicalCompany", Hibernate.DOUBLE)
							.addScalar("socialInsPersonal", Hibernate.DOUBLE).addScalar("socialInsCompany", Hibernate.DOUBLE).addScalar("tax", Hibernate.DOUBLE)
							.addScalar("housingFundPersonal", Hibernate.DOUBLE).addScalar("housingFundCompany", Hibernate.DOUBLE).addScalar("payrollTotal", Hibernate.DOUBLE)
							.addScalar("mboMonthlyPortion", Hibernate.DOUBLE).addScalar("annualBonusMonthlyPortion", Hibernate.DOUBLE).addScalar("total", Hibernate.DOUBLE).addScalar("Emp_empLoginID", Hibernate.STRING);
					
					Iterator it = sqlquery.list().iterator();
					FinancialStatement_ByDepartOrCostCenter fsdoc = null;
					List<FinancialStatement_ByDepartOrCostCenter> fsdoc_list = new ArrayList<FinancialStatement_ByDepartOrCostCenter>();
					// cast and round, keep 2 decimal
					DecimalFormat df = new DecimalFormat("#.00");
					
					while(it.hasNext()) {
						fsdoc = new FinancialStatement_ByDepartOrCostCenter();
						
						Object[] rows = (Object[]) it.next();
						Double bonus = (Double) rows[0];
						Double monthlyBaseSalary = (Double) rows[1];
						Double adjustment = (Double) rows[2];
						Double quartBonus = (Double) rows[3];
						Double OvertimePay = (Double) rows[4];
						Double MealSubsidy = (Double) rows[5];
						Double TransAllowance = (Double) rows[6];
						Double SalaryInPayroll = (Double) rows[7];
						Double netSalary = (Double) rows[8];
						Double medicalPersonal = (Double) rows[9];
						Double medicalCompany = (Double) rows[10];
						Double socialInsPersonal = (Double) rows[11];
						Double socialInsCompany = (Double) rows[12];
						Double tax = (Double) rows[13];
						Double housingFundPersonal = (Double) rows[14];
						Double housingFundCompany = (Double) rows[15];
						Double payrollTotal = (Double) rows[16];
						Double mboMonthlyPortion = (Double) rows[17];
						Double annualBonusMonthlyPortion = (Double) rows[18];
						Double total = (Double) rows[19];
						String emp_loginid = (String) rows[20];
						
						fsdoc.setBonus(Double.parseDouble(df.format(bonus)));
						fsdoc.setMonthlyBaseSalary(Double.parseDouble(df.format(monthlyBaseSalary)));
						fsdoc.setAdjustment(Double.parseDouble(df.format(adjustment)));
						fsdoc.setQuartBonus(Double.parseDouble(df.format(quartBonus)));
						fsdoc.setOvertimePay(Double.parseDouble(df.format(OvertimePay)));
						fsdoc.setMealSubsidy(Double.parseDouble(df.format(MealSubsidy)));
						fsdoc.setTransAllowance(Double.parseDouble(df.format(TransAllowance)));
						fsdoc.setSalaryInPayroll(Double.parseDouble(df.format(SalaryInPayroll)));
						fsdoc.setNetSalary(Double.parseDouble(df.format(netSalary)));
						fsdoc.setMedicalPersonal(Double.parseDouble(df.format(medicalPersonal)));
						fsdoc.setMedicalCompany(Double.parseDouble(df.format(medicalCompany)));
						fsdoc.setSocialInsPersonal(Double.parseDouble(df.format(socialInsPersonal)));
						fsdoc.setSocialInsCompany(Double.parseDouble(df.format(socialInsCompany)));
						fsdoc.setTax(Double.parseDouble(df.format(tax)));
						fsdoc.setHousingFundPersonal(Double.parseDouble(df.format(housingFundPersonal)));
						fsdoc.setHousingFundCompany(Double.parseDouble(df.format(housingFundCompany)));
						fsdoc.setPayrollTotal(Double.parseDouble(df.format(payrollTotal)));
						fsdoc.setMboMonthlyPortion(Double.parseDouble(df.format(mboMonthlyPortion)));
						fsdoc.setAnnualBonusMonthlyPortion(Double.parseDouble(df.format(annualBonusMonthlyPortion)));
						fsdoc.setTotal(Double.parseDouble(df.format(total)));
						fsdoc.setSection_name(emp_loginid);

						fsdoc_list.add(fsdoc);
					}
					return fsdoc_list;
				} catch (RuntimeException re) {
//						log.error("find all failed", re);
					throw re;
				} finally {
//						log.debug("closing session");
					session.close();
				}
			}
				
			
				
				
//	public List<Payrollrecord> findByExample(Payrollrecord instance) {
//		log.debug("finding Payrollrecord instance by example");
//		try {
//			List<Payrollrecord> results = (List<Payrollrecord>) getHibernateTemplate()
//					.createCriteria("com.moravia.hs.base.entity.Payrollrecord")
//					.add(create(instance)).list();
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Payrollrecord instance with property: "
//				+ propertyName + ", value: " + value);
//		try {
//			String queryString = "from Payrollrecord as model where model."
//					+ propertyName + "= ?";
//			Query queryObject = getHibernateTemplate().createQuery(queryString);
//			queryObject.setParameter(0, value);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List<Payrollrecord> findByBaseSalary(Object baseSalary) {
//		return findByProperty(BASE_SALARY, baseSalary);
//	}
//
//	public List<Payrollrecord> findByQuartBonus(Object quartBonus) {
//		return findByProperty(QUART_BONUS, quartBonus);
//	}
//
//	public List<Payrollrecord> findByPostAllowance(Object postAllowance) {
//		return findByProperty(POST_ALLOWANCE, postAllowance);
//	}
//
//	public List<Payrollrecord> findByTransportAllowance(
//			Object transportAllowance) {
//		return findByProperty(TRANSPORT_ALLOWANCE, transportAllowance);
//	}
//
//	public List<Payrollrecord> findByBonus(Object bonus) {
//		return findByProperty(BONUS, bonus);
//	}
//
//	public List<Payrollrecord> findByMealSubsidy(Object mealSubsidy) {
//		return findByProperty(MEAL_SUBSIDY, mealSubsidy);
//	}
//
//	public List<Payrollrecord> findByTotalWorkTime(Object totalWorkTime) {
//		return findByProperty(TOTAL_WORK_TIME, totalWorkTime);
//	}
//
//	public List<Payrollrecord> findByOvertime(Object overtime) {
//		return findByProperty(OVERTIME, overtime);
//	}
//
//	public List<Payrollrecord> findByOvertimePay(Object overtimePay) {
//		return findByProperty(OVERTIME_PAY, overtimePay);
//	}
//
//	public List<Payrollrecord> findByPensionPersonal(Object pensionPersonal) {
//		return findByProperty(PENSION_PERSONAL, pensionPersonal);
//	}
//
//	public List<Payrollrecord> findByPensionCompany(Object pensionCompany) {
//		return findByProperty(PENSION_COMPANY, pensionCompany);
//	}
//
//	public List<Payrollrecord> findByMedicalPersonal(Object medicalPersonal) {
//		return findByProperty(MEDICAL_PERSONAL, medicalPersonal);
//	}
//
//	public List<Payrollrecord> findByMedicalCompany(Object medicalCompany) {
//		return findByProperty(MEDICAL_COMPANY, medicalCompany);
//	}
//
//	public List<Payrollrecord> findByAccumFundPersonal(Object accumFundPersonal) {
//		return findByProperty(ACCUM_FUND_PERSONAL, accumFundPersonal);
//	}
//
//	public List<Payrollrecord> findByAccumFundCompany(Object accumFundCompany) {
//		return findByProperty(ACCUM_FUND_COMPANY, accumFundCompany);
//	}
//
//	public List<Payrollrecord> findByUnempInsuPersonal(Object unempInsuPersonal) {
//		return findByProperty(UNEMP_INSU_PERSONAL, unempInsuPersonal);
//	}
//
//	public List<Payrollrecord> findByUnempInsuCompany(Object unempInsuCompany) {
//		return findByProperty(UNEMP_INSU_COMPANY, unempInsuCompany);
//	}
//
//	public List<Payrollrecord> findByIncomeTax(Object incomeTax) {
//		return findByProperty(INCOME_TAX, incomeTax);
//	}
//
//	public List<Payrollrecord> findByOccupInjureMaternity(
//			Object occupInjureMaternity) {
//		return findByProperty(OCCUP_INJURE_MATERNITY, occupInjureMaternity);
//	}
//
//	public List<Payrollrecord> findByOtherPay(Object otherPay) {
//		return findByProperty(OTHER_PAY, otherPay);
//	}
//
//	public List<Payrollrecord> findByPayrollNote(Object payrollNote) {
//		return findByProperty(PAYROLL_NOTE, payrollNote);
//	}
//
//	public List findAll() {
//		log.debug("finding all Payrollrecord instances");
//		try {
//			String queryString = "from Payrollrecord";
//			Query queryObject = getHibernateTemplate().createQuery(queryString);
//			return queryObject.list();
//		} catch (RuntimeException re) {
//			log.error("find all failed", re);
//			throw re;
//		}
//	}

	/**
	 * Update Pay_Date by loginids
	 * @param payDate
	 * @param loginids
	 */
	public void updatePayDate(String payDate, String loginids) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String queryString = "update payrollrecord set Pay_Date = '" + payDate + "' where Emp_empLoginID IN (" + loginids + ")";
			SQLQuery sqlquery = session.createSQLQuery(queryString);
			sqlquery.executeUpdate();
			log.debug("update Pay_Date successful");
		} catch (RuntimeException re) {
			log.debug("update Pay_Date failed", re);
			throw re;
		} finally {
			session.close();
		}
		
	}
			
			
	public Payrollrecord merge(Payrollrecord detachedInstance) {
		log.debug("merging Payrollrecord instance");
		try {
			Payrollrecord result = (Payrollrecord) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void saveOrUpdate(Payrollrecord instance) {
		log.debug("attaching dirty Payrollrecord instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			getHibernateTemplate().flush();
			System.out.println("payrollDao, saveOrUpdate....");
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Payrollrecord instance) {
		log.debug("attaching clean Payrollrecord instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}