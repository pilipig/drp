package com.gmm.drp.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonCartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonCartExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        public Criteria andPersonIdIsNull() {
            addCriterion("personid is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("personid is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(Integer value) {
            addCriterion("personid =", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(Integer value) {
            addCriterion("personid <>", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(Integer value) {
            addCriterion("personid >", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("personid >=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(Integer value) {
            addCriterion("personid <", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("personid <=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<Integer> values) {
            addCriterion("personid in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<Integer> values) {
            addCriterion("personid not in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("personid between", value1, value2, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("personid not between", value1, value2, "personid");
            return (Criteria) this;
        }
        public Criteria andGoodsIdIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
            return (Criteria) this;
        }
        public Criteria andGoodsNumIsNull() {
            addCriterion("goodsnum is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("goodsnum is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumEqualTo(Integer value) {
            addCriterion("goodsnum =", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotEqualTo(Integer value) {
            addCriterion("goodsnum <>", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThan(Integer value) {
            addCriterion("goodsnum >", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsnum >=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThan(Integer value) {
            addCriterion("goodsnum <", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            addCriterion("goodsnum <=", value, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIn(List<Integer> values) {
            addCriterion("goodsnum in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotIn(List<Integer> values) {
            addCriterion("goodsnum not in", values, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            addCriterion("goodsnum between", value1, value2, "goodsnum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsnum not between", value1, value2, "goodsnum");
            return (Criteria) this;
        }
        public Criteria andGoodsDeliveryTimeIsNull() {
            addCriterion("goodsdeliverytime is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeIsNotNull() {
            addCriterion("goodsdeliverytime is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeEqualTo(Integer value) {
            addCriterion("goodsdeliverytime =", value, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeNotEqualTo(Integer value) {
            addCriterion("goodsdeliverytime <>", value, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeGreaterThan(Integer value) {
            addCriterion("goodsdeliverytime >", value, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsdeliverytime >=", value, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeLessThan(Integer value) {
            addCriterion("goodsdeliverytime <", value, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeLessThanOrEqualTo(Integer value) {
            addCriterion("goodsdeliverytime <=", value, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeNumIn(List<Integer> values) {
            addCriterion("goodsdeliverytime in", values, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeNotIn(List<Integer> values) {
            addCriterion("goodsdeliverytime not in", values, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeBetween(Integer value1, Integer value2) {
            addCriterion("goodsdeliverytime between", value1, value2, "goodsdeliverytime");
            return (Criteria) this;
        }

        public Criteria andGoodsDeliveryTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsdeliverytime not between", value1, value2, "goodsdeliverytime");
            return (Criteria) this;
        }
        public Criteria andCatsIdIsNull() {
            addCriterion("catsid is null");
            return (Criteria) this;
        }

        public Criteria andCatsIdIsNotNull() {
            addCriterion("catsid is not null");
            return (Criteria) this;
        }

        public Criteria andCatsIdEqualTo(Integer value) {
            addCriterion("catsid =", value, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdNotEqualTo(Integer value) {
            addCriterion("catsid <>", value, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdGreaterThan(Integer value) {
            addCriterion("catsid >", value, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("catsid >=", value, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdLessThan(Integer value) {
            addCriterion("catsid <", value, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdLessThanOrEqualTo(Integer value) {
            addCriterion("catsid <=", value, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdNumIn(List<Integer> values) {
            addCriterion("catsid in", values, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdNotIn(List<Integer> values) {
            addCriterion("catsid not in", values, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdBetween(Integer value1, Integer value2) {
            addCriterion("catsid between", value1, value2, "catsid");
            return (Criteria) this;
        }

        public Criteria andCatsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("catsid not between", value1, value2, "catsid");
            return (Criteria) this;
        }
        public Criteria andGoodsGradIsNull() {
            addCriterion("goodsgrad is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIsNotNull() {
            addCriterion("goodsgrad is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradEqualTo(Integer value) {
            addCriterion("goodsgrad =", value, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradNotEqualTo(Integer value) {
            addCriterion("goodsgrad <>", value, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradGreaterThan(Integer value) {
            addCriterion("goodsgrad >", value, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsgrad >=", value, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradLessThan(Integer value) {
            addCriterion("goodsgrad <", value, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradLessThanOrEqualTo(Integer value) {
            addCriterion("goodsgrad <=", value, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradNumIn(List<Integer> values) {
            addCriterion("goodsgrad in", values, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradNotIn(List<Integer> values) {
            addCriterion("goodsgrad not in", values, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradBetween(Integer value1, Integer value2) {
            addCriterion("goodsgrad between", value1, value2, "goodsgrad");
            return (Criteria) this;
        }

        public Criteria andGoodsGradNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsgrad not between", value1, value2, "goodsgrad");
            return (Criteria) this;
        }
        public Criteria andGoodsGradIdIsNull() {
            addCriterion("goodsgradid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdIsNotNull() {
            addCriterion("goodsgradid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdEqualTo(Integer value) {
            addCriterion("goodsgradid =", value, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdNotEqualTo(Integer value) {
            addCriterion("goodsgradid <>", value, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdGreaterThan(Integer value) {
            addCriterion("goodsgradid >", value, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsgradid >=", value, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdLessThan(Integer value) {
            addCriterion("goodsgradid <", value, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdLessThanOrEqualTo(Integer value) {
            addCriterion("goodsgradid <=", value, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdNumIn(List<Integer> values) {
            addCriterion("goodsgradid in", values, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdNotIn(List<Integer> values) {
            addCriterion("goodsgradid not in", values, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdBetween(Integer value1, Integer value2) {
            addCriterion("goodsgradid between", value1, value2, "goodsgradid");
            return (Criteria) this;
        }

        public Criteria andGoodsGradIdNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsgradid not between", value1, value2, "goodsgradid");
            return (Criteria) this;
        }
        public Criteria andCreateTimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
        public Criteria andRetailPriceIsNull() {
            addCriterion("retailprice is null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIsNotNull() {
            addCriterion("retailprice is not null");
            return (Criteria) this;
        }

        public Criteria andRetailPriceEqualTo(BigDecimal value) {
            addCriterion("retailprice =", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotEqualTo(BigDecimal value) {
            addCriterion("retailprice <>", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThan(BigDecimal value) {
            addCriterion("retailprice >", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("retailprice >=", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThan(BigDecimal value) {
            addCriterion("retailprice <", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("retailprice <=", value, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceIn(List<BigDecimal> values) {
            addCriterion("retailprice in", values, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotIn(List<BigDecimal> values) {
            addCriterion("retailprice not in", values, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailprice between", value1, value2, "retailprice");
            return (Criteria) this;
        }

        public Criteria andRetailPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("retailprice not between", value1, value2, "retailprice");
            return (Criteria) this;
        }
        public Criteria andMarketPriceIsNull() {
            addCriterion("marketprice is null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIsNotNull() {
            addCriterion("marketprice is not null");
            return (Criteria) this;
        }

        public Criteria andMarketPriceEqualTo(BigDecimal value) {
            addCriterion("marketprice =", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotEqualTo(BigDecimal value) {
            addCriterion("marketprice <>", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThan(BigDecimal value) {
            addCriterion("marketprice >", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("marketprice >=", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThan(BigDecimal value) {
            addCriterion("marketprice <", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("marketprice <=", value, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceIn(List<BigDecimal> values) {
            addCriterion("marketprice in", values, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotIn(List<BigDecimal> values) {
            addCriterion("marketprice not in", values, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketprice between", value1, value2, "marketprice");
            return (Criteria) this;
        }

        public Criteria andMarketPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("marketprice not between", value1, value2, "marketprice");
            return (Criteria) this;
        }
        public Criteria andPersonNameIsNull() {
            addCriterion("personname is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("personname is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("personname =", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("personname <>", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("personname >", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("personname >=", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("personname <", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("personname <=", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("personname like", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("personname not like", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("personname in", values, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("personname not in", values, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("personname between", value1, value2, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("personname not between", value1, value2, "personname");
            return (Criteria) this;
        }
        public Criteria andGoodsNameIsNull() {
            addCriterion("goodsname is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goodsname is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goodsname =", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goodsname <>", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goodsname >", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goodsname >=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goodsname <", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goodsname <=", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goodsname like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goodsname not like", value, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goodsname in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goodsname not in", values, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goodsname between", value1, value2, "goodsname");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goodsname not between", value1, value2, "goodsname");
            return (Criteria) this;
        }
        public Criteria andGoodsImageIsNull() {
            addCriterion("goodsimage is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIsNotNull() {
            addCriterion("goodsimage is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImageEqualTo(String value) {
            addCriterion("goodsimage =", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotEqualTo(String value) {
            addCriterion("goodsimage <>", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageGreaterThan(String value) {
            addCriterion("goodsimage >", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageGreaterThanOrEqualTo(String value) {
            addCriterion("goodsimage >=", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLessThan(String value) {
            addCriterion("goodsimage <", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLessThanOrEqualTo(String value) {
            addCriterion("goodsimage <=", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageLike(String value) {
            addCriterion("goodsimage like", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotLike(String value) {
            addCriterion("goodsimage not like", value, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageIn(List<String> values) {
            addCriterion("goodsimage in", values, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotIn(List<String> values) {
            addCriterion("goodsimage not in", values, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageBetween(String value1, String value2) {
            addCriterion("goodsimage between", value1, value2, "goodsimage");
            return (Criteria) this;
        }

        public Criteria andGoodsImageNotBetween(String value1, String value2) {
            addCriterion("goodsimage not between", value1, value2, "goodsimage");
            return (Criteria) this;
        }
        public Criteria andCatsNameIsNull() {
            addCriterion("catsname is null");
            return (Criteria) this;
        }

        public Criteria andCatsNameIsNotNull() {
            addCriterion("catsname is not null");
            return (Criteria) this;
        }

        public Criteria andCatsNameEqualTo(String value) {
            addCriterion("catsname =", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameNotEqualTo(String value) {
            addCriterion("catsname <>", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameGreaterThan(String value) {
            addCriterion("catsname >", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameGreaterThanOrEqualTo(String value) {
            addCriterion("catsname >=", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameLessThan(String value) {
            addCriterion("catsname <", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameLessThanOrEqualTo(String value) {
            addCriterion("catsname <=", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameLike(String value) {
            addCriterion("catsname like", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameNotLike(String value) {
            addCriterion("catsname not like", value, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameIn(List<String> values) {
            addCriterion("catsname in", values, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameNotIn(List<String> values) {
            addCriterion("catsname not in", values, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameBetween(String value1, String value2) {
            addCriterion("catsname between", value1, value2, "catsname");
            return (Criteria) this;
        }

        public Criteria andCatsNameNotBetween(String value1, String value2) {
            addCriterion("catsname not between", value1, value2, "catsname");
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