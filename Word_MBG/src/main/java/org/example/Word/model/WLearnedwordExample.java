package org.example.Word.model;

import java.util.ArrayList;
import java.util.List;

public class WLearnedwordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WLearnedwordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Long value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Long value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Long value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Long value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Long value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Long value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Long> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Long> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Long value1, Long value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Long value1, Long value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andWidIsNull() {
            addCriterion("wid is null");
            return (Criteria) this;
        }

        public Criteria andWidIsNotNull() {
            addCriterion("wid is not null");
            return (Criteria) this;
        }

        public Criteria andWidEqualTo(Long value) {
            addCriterion("wid =", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotEqualTo(Long value) {
            addCriterion("wid <>", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThan(Long value) {
            addCriterion("wid >", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidGreaterThanOrEqualTo(Long value) {
            addCriterion("wid >=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThan(Long value) {
            addCriterion("wid <", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidLessThanOrEqualTo(Long value) {
            addCriterion("wid <=", value, "wid");
            return (Criteria) this;
        }

        public Criteria andWidIn(List<Long> values) {
            addCriterion("wid in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotIn(List<Long> values) {
            addCriterion("wid not in", values, "wid");
            return (Criteria) this;
        }

        public Criteria andWidBetween(Long value1, Long value2) {
            addCriterion("wid between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andWidNotBetween(Long value1, Long value2) {
            addCriterion("wid not between", value1, value2, "wid");
            return (Criteria) this;
        }

        public Criteria andIscorrectIsNull() {
            addCriterion("iscorrect is null");
            return (Criteria) this;
        }

        public Criteria andIscorrectIsNotNull() {
            addCriterion("iscorrect is not null");
            return (Criteria) this;
        }

        public Criteria andIscorrectEqualTo(Integer value) {
            addCriterion("iscorrect =", value, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectNotEqualTo(Integer value) {
            addCriterion("iscorrect <>", value, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectGreaterThan(Integer value) {
            addCriterion("iscorrect >", value, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectGreaterThanOrEqualTo(Integer value) {
            addCriterion("iscorrect >=", value, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectLessThan(Integer value) {
            addCriterion("iscorrect <", value, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectLessThanOrEqualTo(Integer value) {
            addCriterion("iscorrect <=", value, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectIn(List<Integer> values) {
            addCriterion("iscorrect in", values, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectNotIn(List<Integer> values) {
            addCriterion("iscorrect not in", values, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectBetween(Integer value1, Integer value2) {
            addCriterion("iscorrect between", value1, value2, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andIscorrectNotBetween(Integer value1, Integer value2) {
            addCriterion("iscorrect not between", value1, value2, "iscorrect");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearIsNull() {
            addCriterion("study_time_year is null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearIsNotNull() {
            addCriterion("study_time_year is not null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearEqualTo(Integer value) {
            addCriterion("study_time_year =", value, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearNotEqualTo(Integer value) {
            addCriterion("study_time_year <>", value, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearGreaterThan(Integer value) {
            addCriterion("study_time_year >", value, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_time_year >=", value, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearLessThan(Integer value) {
            addCriterion("study_time_year <", value, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearLessThanOrEqualTo(Integer value) {
            addCriterion("study_time_year <=", value, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearIn(List<Integer> values) {
            addCriterion("study_time_year in", values, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearNotIn(List<Integer> values) {
            addCriterion("study_time_year not in", values, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearBetween(Integer value1, Integer value2) {
            addCriterion("study_time_year between", value1, value2, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeYearNotBetween(Integer value1, Integer value2) {
            addCriterion("study_time_year not between", value1, value2, "studyTimeYear");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthIsNull() {
            addCriterion("study_time_month is null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthIsNotNull() {
            addCriterion("study_time_month is not null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthEqualTo(Integer value) {
            addCriterion("study_time_month =", value, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthNotEqualTo(Integer value) {
            addCriterion("study_time_month <>", value, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthGreaterThan(Integer value) {
            addCriterion("study_time_month >", value, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_time_month >=", value, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthLessThan(Integer value) {
            addCriterion("study_time_month <", value, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthLessThanOrEqualTo(Integer value) {
            addCriterion("study_time_month <=", value, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthIn(List<Integer> values) {
            addCriterion("study_time_month in", values, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthNotIn(List<Integer> values) {
            addCriterion("study_time_month not in", values, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthBetween(Integer value1, Integer value2) {
            addCriterion("study_time_month between", value1, value2, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("study_time_month not between", value1, value2, "studyTimeMonth");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayIsNull() {
            addCriterion("study_time_day is null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayIsNotNull() {
            addCriterion("study_time_day is not null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayEqualTo(Integer value) {
            addCriterion("study_time_day =", value, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayNotEqualTo(Integer value) {
            addCriterion("study_time_day <>", value, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayGreaterThan(Integer value) {
            addCriterion("study_time_day >", value, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("study_time_day >=", value, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayLessThan(Integer value) {
            addCriterion("study_time_day <", value, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayLessThanOrEqualTo(Integer value) {
            addCriterion("study_time_day <=", value, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayIn(List<Integer> values) {
            addCriterion("study_time_day in", values, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayNotIn(List<Integer> values) {
            addCriterion("study_time_day not in", values, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayBetween(Integer value1, Integer value2) {
            addCriterion("study_time_day between", value1, value2, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeDayNotBetween(Integer value1, Integer value2) {
            addCriterion("study_time_day not between", value1, value2, "studyTimeDay");
            return (Criteria) this;
        }

        public Criteria andStudyTimeIsNull() {
            addCriterion("study_time is null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeIsNotNull() {
            addCriterion("study_time is not null");
            return (Criteria) this;
        }

        public Criteria andStudyTimeEqualTo(String value) {
            addCriterion("study_time =", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeNotEqualTo(String value) {
            addCriterion("study_time <>", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeGreaterThan(String value) {
            addCriterion("study_time >", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeGreaterThanOrEqualTo(String value) {
            addCriterion("study_time >=", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeLessThan(String value) {
            addCriterion("study_time <", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeLessThanOrEqualTo(String value) {
            addCriterion("study_time <=", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeLike(String value) {
            addCriterion("study_time like", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeNotLike(String value) {
            addCriterion("study_time not like", value, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeIn(List<String> values) {
            addCriterion("study_time in", values, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeNotIn(List<String> values) {
            addCriterion("study_time not in", values, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeBetween(String value1, String value2) {
            addCriterion("study_time between", value1, value2, "studyTime");
            return (Criteria) this;
        }

        public Criteria andStudyTimeNotBetween(String value1, String value2) {
            addCriterion("study_time not between", value1, value2, "studyTime");
            return (Criteria) this;
        }

        public Criteria andRecentIsNull() {
            addCriterion("recent is null");
            return (Criteria) this;
        }

        public Criteria andRecentIsNotNull() {
            addCriterion("recent is not null");
            return (Criteria) this;
        }

        public Criteria andRecentEqualTo(Integer value) {
            addCriterion("recent =", value, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentNotEqualTo(Integer value) {
            addCriterion("recent <>", value, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentGreaterThan(Integer value) {
            addCriterion("recent >", value, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentGreaterThanOrEqualTo(Integer value) {
            addCriterion("recent >=", value, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentLessThan(Integer value) {
            addCriterion("recent <", value, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentLessThanOrEqualTo(Integer value) {
            addCriterion("recent <=", value, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentIn(List<Integer> values) {
            addCriterion("recent in", values, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentNotIn(List<Integer> values) {
            addCriterion("recent not in", values, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentBetween(Integer value1, Integer value2) {
            addCriterion("recent between", value1, value2, "recent");
            return (Criteria) this;
        }

        public Criteria andRecentNotBetween(Integer value1, Integer value2) {
            addCriterion("recent not between", value1, value2, "recent");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}