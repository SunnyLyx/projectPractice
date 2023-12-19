package edu.fosu.quartz.task;

import edu.fosu.common.utils.spring.SpringUtils;
import edu.fosu.teach.domain.*;
import edu.fosu.teach.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 定时任务调度测试
 *
 */
@Component("fosutechTask")
public class FosutechTask {

    @Autowired
    private  ITeachClassAttendanceService ITeachClassAttendance = SpringUtils.getBean(ITeachClassAttendanceService.class);

    @Autowired
    private ITeachAttendanceService ITeachAttendance = SpringUtils.getBean(ITeachAttendanceService.class);

    @Autowired
    private ITeachClassHomeworkService ITeachClassHomework = SpringUtils.getBean(ITeachClassHomeworkService.class);

    @Autowired
    private ITeachJobService ITeachJobService = SpringUtils.getBean(ITeachJobService.class);

    @Autowired
    private ITeachExamStatisticsService ITeachExamStatistics = SpringUtils.getBean(ITeachExamStatisticsService.class);

    @Autowired
    private ITeachExamService ITeachExam = SpringUtils.getBean(ITeachExamService.class);

    @Autowired
    private ITeachSubjectAttendanceService ITeachSubjectAttendance = SpringUtils.getBean(ITeachSubjectAttendanceService.class);

    @Autowired
    private ITeachSubjectService ITeachSubjectService = SpringUtils.getBean(ITeachSubjectService.class);

    @Autowired
    private ITeachClassStatisticsService ITeachClassStatisticsService = SpringUtils.getBean(ITeachClassStatisticsService.class);

    @Autowired
    private ITeachClassesService ITeachClassesService = SpringUtils.getBean(ITeachClassesService.class);

    @Autowired
    private ITeachInspectionItemsService teachInspectionItemsService = SpringUtils.getBean(ITeachInspectionItemsService.class);

    public void ryParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    /**
     * 统计班级考勤信息
     */
    public void statisticsTeachClassAttendance() {
        System.out.println("统计班级考勤信息");

        //获取统计数据
        List<TeachClassAttendance> teachClassAttendanceList = ITeachClassAttendance.selectTeachClassAttendanceTask();

        for (TeachClassAttendance teachClassAttendance:teachClassAttendanceList
             ) {
            Double attendancenum = Double.valueOf(teachClassAttendance.getAttendancenum());
            Double studentnum = Double.valueOf(teachClassAttendance.getStudentnum());
            Double attendance = Double.valueOf(attendancenum/studentnum)*100;
            //只保留0位小数
            String class_attendance =  String.format("%.0f", attendance).concat("%");
            teachClassAttendance.setClassAttendance(class_attendance);
            ITeachClassAttendance.insertTeachClassAttendance(teachClassAttendance);
        }

    }
    /**
     * 统计项目信息统计
     */
    public void statisticsTeachSubjectAttendance() {
        System.out.println("统计班级项目信息");

        //获取统计数据
        List<TeachSubjectAttendance> teachSubjectAttendanceList = ITeachSubjectAttendance.selectTeachSubjectAttendanceTask();

        for (TeachSubjectAttendance teachSubjectAttendance:teachSubjectAttendanceList
             ) {
            Double bestnum = Double.valueOf(teachSubjectAttendance.getBestnum());
            Double goodnum = Double.valueOf(teachSubjectAttendance.getGoodnum());
            Double poornum = Double.valueOf(teachSubjectAttendance.getPoornum());

            Double studentnum = Double.valueOf(teachSubjectAttendance.getStudentnum());
            Double bestattendance = Double.valueOf((bestnum)/studentnum)*100;
            Double goodattendance = Double.valueOf((goodnum)/studentnum)*100;
            Double poorattendance = Double.valueOf((poornum)/studentnum)*100;
            //只保留0位小数
            teachSubjectAttendance.setBestAttendance(String.format("%.0f", bestattendance).concat("%"));
            teachSubjectAttendance.setGoodAttendance(String.format("%.0f", goodattendance).concat("%"));
            teachSubjectAttendance.setPoorAttendance(String.format("%.0f", poorattendance).concat("%"));
            ITeachSubjectAttendance.insertTeachSubjectAttendance(teachSubjectAttendance);
        }
    }

    /**
     * 统计班级作业信息
     */
    public void statisticsTeachClassHomework() {
        System.out.println("统计班级作业信息");

        //获取统计数据
        List<TeachClassHomework> teachClassAttendanceList = ITeachClassHomework.selectTeachClassHomeworkTask();

        for (TeachClassHomework teachClassHomework:teachClassAttendanceList
             ) {
            Double workbestnum = Double.valueOf(teachClassHomework.getWorkbestnum());
            Double workgoodnum = Double.valueOf(teachClassHomework.getWorkgoodnum());

            Double studentnum = Double.valueOf(teachClassHomework.getStudentnum());
            Double attendance = Double.valueOf((workbestnum)/studentnum)*100;
//            Double bestattendance = Double.valueOf((workbestnum)/studentnum)*100;
            //只保留0位小数
            String class_attendance =  String.format("%.0f", attendance).concat("%");
            teachClassHomework.setClassHomeworkAttendance(class_attendance);
            ITeachClassHomework.insertTeachClassHomework(teachClassHomework);
        }

    }

    public void statisticsTeachClassExam(){
        System.out.println("统计班级考试信息");

        //获取统计数据
        List<TeachExamStatistics> teachExamStatisticsList = ITeachExamStatistics.selectTeachExamStatisticsTask();
        for (TeachExamStatistics teachExamStatistics:teachExamStatisticsList){
            Double pass = Double.valueOf(teachExamStatistics.getPass());
            Double studentnum = Double.valueOf(teachExamStatistics.getStudentNum());
            String acceptability = String.format("%.0f", Double.valueOf(pass/studentnum)*100).concat("%");
            teachExamStatistics.setAcceptability(acceptability);
            ITeachExamStatistics.insertTeachExamStatistics(teachExamStatistics);
        }
    }

    public void statisticsTeachClassMonth(){
        System.out.println("统计班级月信息");

        // 获取当月第一天和最后一天
        Calendar cale = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        String month1 = "";
        if((month + "").length() == 1){
            month1 = "0" + month;
        }else {
            month1 = String.valueOf(month);
        }
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());

        TeachAttendance teachAttendance = new TeachAttendance();
        TeachJob teachJob = new TeachJob();
        TeachClasses teachClasses = new TeachClasses();
        TeachExam teachExam = new TeachExam();
        TeachSubject teachSubject = new TeachSubject();
        TeachClassStatistics teachClassStatistics = new TeachClassStatistics();
        List<TeachClasses> classesList = ITeachClassesService.selectTeachClassesList(teachClasses);
        for (TeachClasses teachClasses1:classesList) {
            teachAttendance.setClassId(teachClasses1.getClassId());
            teachAttendance.setStartDatetime(firstday);
            teachAttendance.setEndDatetime(lastday);
            int a = ITeachAttendance.selectTeachAttendanceListCount(teachAttendance);

            teachExam.setClassId(teachClasses1.getClassId());
            teachExam.setStarttime(firstday);
            teachExam.setEndtime(lastday);
            int b = ITeachExam.selectTeachExamListCount(teachExam);

            teachSubject.setClassId(teachClasses1.getClassId());
            teachSubject.setStarttime(firstday);
            teachSubject.setEndtime(lastday);
            int c = ITeachSubjectService.selectTeachSubjectListCount(teachSubject);

            teachJob.setClassId(teachClasses1.getClassId());
            teachJob.setStarttime(firstday);
            teachJob.setEndtime(lastday);
            int d = ITeachJobService.selectTeachJobListCount(teachJob);

            if(a > 0){
                if(b > 0){
                    List<TeachExam> teachExamList = ITeachExam.selectTeachExamList1(teachExam);
                    int sum3 = 0;
                    for (TeachExam teachExam1 : teachExamList){
                        String acceptability = teachExam1.getAcceptability();
                        sum3 = sum3 + Integer.valueOf(acceptability.substring(0,acceptability.length()-1));
                    }
                    String examAcceptability = String.format("%.0f", Double.valueOf(Double.valueOf(sum3)/Double.valueOf(teachExamList.size()))).concat("%");
                    teachClassStatistics.setExamAcceptability(examAcceptability);
                } else {
                    teachClassStatistics.setExamAcceptability("0%");
                }
                if(c > 0){
                    List<TeachSubject> teachSubjectList = ITeachSubjectService.selectTeachSubjectList1(teachSubject);
                    int sum4 = 0;
                    for (TeachSubject teachSubject1 : teachSubjectList){
                        String subjectPercentageComplete = teachSubject1.getBestAttendance();
                        sum4 = sum4 + Integer.valueOf(subjectPercentageComplete.substring(0,subjectPercentageComplete.length()-1));
                    }
                    String examAcceptability = String.format("%.0f", Double.valueOf(Double.valueOf(sum4)/Double.valueOf(teachSubjectList.size()))).concat("%");
                    teachClassStatistics.setSubjectPercentageComplete(examAcceptability);
                }else {
                    teachClassStatistics.setSubjectPercentageComplete("0%");
                }
                if (d>0){
                    List<TeachJob> list2 = ITeachJobService.selectTeachJobList1(teachJob);
                    int sum2 = 0;
                    for (TeachJob teachJob1:list2) {
                        String classHomeworkAttendance = teachJob1.getClassHomeworkAttendance();
                        sum2 = sum2 + Integer.valueOf(classHomeworkAttendance.substring(0,classHomeworkAttendance.length()-1));
                    }
                    String jobPercentageComplete = String.format("%.0f", Double.valueOf(Double.valueOf(sum2)/Double.valueOf(list2.size()))).concat("%");
                    teachClassStatistics.setJobPercentageComplete(jobPercentageComplete);
                }else {
                    teachClassStatistics.setJobPercentageComplete("0%");
                }
                List<TeachAttendance> list = ITeachAttendance.selectTeachAttendanceList1(teachAttendance);
                int sum1 = 0;
                for (TeachAttendance TeachAttendance1:list) {
                    String classAttendance = TeachAttendance1.getClassAttendance();
                    sum1 = sum1 + Integer.valueOf(classAttendance.substring(0,classAttendance.length()-1));
                }
                String attendence = String.format("%.0f", Double.valueOf(Double.valueOf(sum1)/Double.valueOf(list.size()))).concat("%");
                teachClassStatistics.setId(UUID.randomUUID().toString());
                teachClassStatistics.setClassId(teachClasses1.getClassId());
                teachClassStatistics.setMonth(year + "-" + month1 );
                teachClassStatistics.setAttendence(attendence);
                teachClassStatistics.setCreatetime(new Date());

                ITeachClassStatisticsService.insertTeachClassStatistics(teachClassStatistics);
            }
        }
    }

    public void statisticsTeacherMonth(){
        System.out.println("统计老师月信息");

        // 获取当月第一天和最后一天
        Calendar cale = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;
        String month1 = "";
        if((month + "").length() == 1){
            month1 = "0" + month;
        }
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        lastday = format.format(cale.getTime());

        TeachInspectionItems teachInspectionItems = new TeachInspectionItems();
        teachInspectionItems.setAssessId(3);
        List<TeachInspectionItems> teachInspectionItemsList = teachInspectionItemsService.selectTeachInspectionItemsList(teachInspectionItems);
        System.out.println(teachInspectionItemsList);
        TeachAttendance teachAttendance = new TeachAttendance();
        for (TeachInspectionItems teachInspectionItems1 :teachInspectionItemsList ){
            if("专业课出勤率".equals(teachInspectionItems1.getInspectionItemsWeight())){
                teachAttendance.setTeacherId(142);
                teachAttendance.setLesson(1);
                teachAttendance.setStartDatetime(firstday);
                teachAttendance.setEndDatetime(lastday);
                int a = ITeachAttendance.selectTeachAttendanceListCount(teachAttendance);
                if (a>0){
                    List<TeachAttendance> list = ITeachAttendance.selectTeachAttendanceList1(teachAttendance);
                    int sum1 = 0;
                    for (TeachAttendance TeachAttendance1:list) {
                        String classAttendance = TeachAttendance1.getClassAttendance();
                        sum1 = sum1 + Integer.valueOf(classAttendance.substring(0,classAttendance.length()-1));
                    }
                    String attendence = String.format("%.0f", Double.valueOf(Double.valueOf(sum1)/Double.valueOf(list.size()))).concat("%");
                }
            }
            if("实训课出勤率".equals(teachInspectionItems1.getInspectionItemsWeight())){
                teachAttendance.setTeacherId(142);
                teachAttendance.setLesson(2);
                teachAttendance.setStartDatetime(firstday);
                teachAttendance.setEndDatetime(lastday);
                int a = ITeachAttendance.selectTeachAttendanceListCount(teachAttendance);
                if (a>0){
                    List<TeachAttendance> list = ITeachAttendance.selectTeachAttendanceList1(teachAttendance);
                    int sum1 = 0;
                    for (TeachAttendance TeachAttendance1:list) {
                        String classAttendance = TeachAttendance1.getClassAttendance();
                        sum1 = sum1 + Integer.valueOf(classAttendance.substring(0,classAttendance.length()-1));
                    }
                    String attendence = String.format("%.0f", Double.valueOf(Double.valueOf(sum1)/Double.valueOf(list.size()))).concat("%");
                }
            }
            if("项目合格率".equals(teachInspectionItems1.getInspectionItemsWeight())){
                teachAttendance.setTeacherId(142);
                teachAttendance.setLesson(2);
                teachAttendance.setStartDatetime(firstday);
                teachAttendance.setEndDatetime(lastday);
                int a = ITeachAttendance.selectTeachAttendanceListCount(teachAttendance);
                if (a>0){
                    List<TeachAttendance> list = ITeachAttendance.selectTeachAttendanceList1(teachAttendance);
                    int sum1 = 0;
                    for (TeachAttendance TeachAttendance1:list) {
                        String classAttendance = TeachAttendance1.getClassAttendance();
                        sum1 = sum1 + Integer.valueOf(classAttendance.substring(0,classAttendance.length()-1));
                    }
                    String attendence = String.format("%.0f", Double.valueOf(Double.valueOf(sum1)/Double.valueOf(list.size()))).concat("%");
                }
            }
        }
    }
}
