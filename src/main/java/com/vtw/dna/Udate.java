package com.vtw.dna;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Udate {
    public final static String PREFIX_FORMAT_YYYY              = "yyyy";              		/** 2017              		*/
    public final static String PREFIX_FORMAT_MM                = "MM";               		/** 01                		*/
    public final static String PREFIX_FORMAT_DD                = "dd";                		/** 01                		*/
    public final static String PREFIX_FORMAT_YYYYMM            = "yyyyMM";            		/** 201712            		*/
    public final static String PREFIX_FORMAT_YYYYMMDD          = "yyyyMMdd";          		/** 20171231          		*/
    public final static String PREFIX_FORMAT_YYYYMMDDHHMMSS    = "yyyyMMddHHmmss";    		/** 20171231120303    		*/
    public final static String PREFIX_FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS"; 		/** 20171231120303123 		*/
    public final static String PREFIX_FORMAT_YYYY_MM_DD        = "yyyy.MM.dd";        		/** 2017.12.31        		*/
    public final static String PREFIX_FORMAT_YYYY_MM_DD2       = "yyyy-MM-dd";        		/** 2017-12-31        		*/
    public final static String PREFIX_FORMAT_YYYY_MM_DD_HMS    = "yyyy.MM.dd HH:mm:ss";		/** 2017.12.31 12:03:03		*/
    public final static String PREFIX_FORMAT_YYYY_MM_DD_HMS2   = "yyyy-MM-dd HH:mm:ss";		/** 2017-12-31 12:03:03		*/
    public final static String PREFIX_FORMAT_YYYY_MM_DD_HMS3   = "yyyy년MM월dd일 HH:mm:ss";	/** 2017년12월31일 12:03:03	*/
    public final static String PREFIX_FORMAT_YYYY_MM_DD_HMS4   = "yyyy/MM/dd HH:mm:ss";		/** 2017/12/31 12:03:03	*/

    /**
     * 오늘 날짜를 yyyyMMdd 형태로 반환한다.
     * @return
     */
    public static String getToday() {
        return getDate(PREFIX_FORMAT_YYYYMMDD);
    }

    /**
     * 현재 날짜를 반환한다.
     * <br><br>
     *
     * @param  _format 해당 날짜 포멧
     * @return         해당 날짜
     ********************************************************************************************/
    public static String getDate(String _format) {

        return new SimpleDateFormat(_format).format(new Date());
    }

    /**
     * 해당 날짜의 더한 월를 반환한다.
     * <br><br>
     *
     * @param  _format 		해당 날짜 포멧
     * @param
     * @param  _month  		더한 월
     * @return         		계산 된 날짜
     *********************************************************************************/
    public static String getDayAddMonth(String _format, String _date, int _month) {

        SimpleDateFormat format      = new SimpleDateFormat(_format);
        Calendar calendar    = Calendar.getInstance();

        try                    { calendar.setTime(format.parse(_date));	}
        catch(ParseException e){ e.printStackTrace();                   }

        calendar.add(Calendar.MONTH, _month);

        return new SimpleDateFormat(_format).format(calendar.getTime());
    }

    /**
     * 해당 날짜의 더한 날짜 반환한다.
     * <br><br>
     *
     * @param  _format 		해당 날짜 포멧
     * @param
     * @param  _day  		더한 일
     * @return         		계산 된 날짜
     *********************************************************************************/
    public static String getDayAddDay(String _format, String _date, int _day) {

        SimpleDateFormat format      = new SimpleDateFormat(_format);
        Calendar         calendar    = Calendar.getInstance();

        try                    { calendar.setTime(format.parse(_date));	}
        catch(ParseException e){ e.printStackTrace();                   }

        calendar.add(Calendar.DATE, _day);

        return new SimpleDateFormat(_format).format(calendar.getTime());
    }

    /**
     * 해당 날짜의 더한 날짜 반환한다.
     * <br><br>
     *
     * @param  _format 		해당 날짜 포멧
     * @param
     * @param  _day  		뺄 일
     * @return         		계산 된 날짜
     *********************************************************************************/
    public static String getDaySubDay(String _format, String _date, int _day) {

        SimpleDateFormat format      = new SimpleDateFormat(_format);
        Calendar         calendar    = Calendar.getInstance();

        try                    { calendar.setTime(format.parse(_date));	}
        catch(ParseException e){ e.printStackTrace();                   }

        calendar.add(Calendar.DATE, -_day);

        return new SimpleDateFormat(_format).format(calendar.getTime());
    }

    /**
     * 해당 월 말일을 반환한다.
     * <br><br>
     *
     * @param  _yyyymm	해당 월
     * @return         	계산 된 날짜
     *********************************************************************************/
    public static String getLastDayOfMonth(String _yyyymm) {

        if(null == _yyyymm || 6 != _yyyymm.length()) return "";

        Calendar calendar = Calendar.getInstance();
        calendar.set(
                Integer.parseInt(_yyyymm.substring(0, 4)),
                Integer.parseInt(_yyyymm.substring(4))-1,
                1);

        int lastDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return String.valueOf(lastDate);
    }

    /**
     * String 을 Date 로 변환
     * @param _format
     * @param _yyyymmddhhmmss
     * @return
     * @throws ParseException
     */
    public static Date getDateFromString(String _format, String _yyyymmddhhmmss) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat(_format);
        Date result;

        try                      { result = format.parse(_yyyymmddhhmmss); }
        catch (ParseException e) { throw e; }

        return result;
    }

    /**
     * Date 를 String 으로 변환
     * @param _format
     * @param _date
     * @return
     * @throws ParseException
     */
    public static String getStringFromDate(String _format, Date _date) {
        return new SimpleDateFormat(_format).format(_date);
    }

    /**
     * String 두 날짜 사이의 날짜값 list 형태로 반환
     * 주의사항 : 주말은 반환되지 않음.
     * @param _startDt
     * @param _endDt
     * @return
     * @throws ParseException
     */
    public static List<String> getBetweenTwoDatesList(String _startDt, String _endDt) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date startDt;
        Date endDt;

        //Date타입으로 변경
        try {
            startDt = format.parse(_startDt);
            endDt   = format.parse(_endDt);
        } catch (ParseException e) { throw e; }

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        //Calendar 타입으로 변경 add()메소드로 1일씩 추가해 주기위해 변경
        c1.setTime( startDt );
        c2.setTime( endDt );

        //시작날짜와 끝 날짜를 비교해, 시작날짜가 작거나 같은 경우 list 셋팅, 주말 제외

        List<String> dates = new ArrayList<>();
        while( c1.compareTo( c2 ) !=1 ){
            //일자 셋팅
            String date = format.format(c1.getTime());
            if(getDateDay(date) != 1 && getDateDay(date) != 7) {
                dates.add(date);
            }
            //시작날짜 + 1 일
            c1.add(Calendar.DATE, 1);
        }

        return dates;
    }

    /**
     * 날짜 차이 계산
     * @param begin
     * @param end
     * @return
     * @throws Exception
     */
    public static long diffOfDate(String begin, String end) throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        Date beginDate = formatter.parse(begin);
        Date endDate = formatter.parse(end);

        long diff = endDate.getTime() - beginDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays;
    }

    /**
     * 특정 날짜에 대한 요일값 반환
     * 1-일, 2-월, 3-화, 4-수, 5-목, 6-금, 7-토
     * @param date
     * @return
     * @throws ParseException
     */
    public static Integer getDateDay(String date) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd") ;
        Date nDate = dateFormat.parse(date);

        Calendar cal = Calendar.getInstance() ;
        cal.setTime(nDate);
        return cal.get(Calendar.DAY_OF_WEEK) ;
    }

    /**
     * 두 날짜 사이 가까운 날짜 조회
     * 가장 가까운 이전날짜를 먼저 조회 후 없으면 이후 날짜를 찾아 리턴
     * 값이 없을 경우 null 리턴
     * @param startDt         : 시작일
     * @param endDt           : 종료일
     * @param targetDt        : 타겟날짜
     * @param nonTargetDtList : 두 날짜 사이 제외 일자
     * @return
     * @throws ParseException
     */
    public static String getNearTwoDates(String startDt, String endDt, String targetDt, List<String> nonTargetDtList) throws ParseException {

        List<String> datelist = getBetweenTwoDatesList(startDt, endDt);

        Date targetDate = getDateFromString(PREFIX_FORMAT_YYYYMMDD, targetDt);
        Date resultDate = null;

        // 오름차순 정렬 후 가까운 이전 날짜 조회
        Collections.sort(datelist);
        for(String dateStr : datelist) {
            for(String nonTarget : nonTargetDtList) {
                if(!nonTarget.equals(dateStr)) {
                    Date date = getDateFromString(PREFIX_FORMAT_YYYYMMDD, dateStr);
                    if(date.compareTo(targetDate) <= 0) {
                        resultDate = date;
                    }
                }
            }
        }

        // 가까운 이전 날짜가 없을 경우 이후 날짜 조회
        if(resultDate == null) {
            // 내림차순 정렬 후 가까운 이후 날짜 조회
            Collections.reverse(datelist);
            for(String dateStr : datelist) {
                for(String nonTarget : nonTargetDtList) {
                    if(!nonTarget.equals(dateStr)) {
                        Date date = getDateFromString(PREFIX_FORMAT_YYYYMMDD, dateStr);
                        if(date.compareTo(targetDate) > 0) {
                            resultDate = date;
                        }
                    }
                }
            }
        }

        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return resultDate==null ? null : format.format(resultDate);
    }
}
