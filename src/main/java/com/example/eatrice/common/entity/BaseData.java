package com.example.eatrice.common.entity;

import cn.hutool.core.util.StrUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.util.*;

@SuppressWarnings("rawtypes")
public class BaseData extends HashMap implements Map {

    private static final long serialVersionUID = 1L;

    Map map = null;
    HttpServletRequest request;

    @SuppressWarnings("unchecked")
    public BaseData(HttpServletRequest request) {
        this.request = request;
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        map = returnMap;
    }

    public BaseData() {
        map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj = null;
        if (map.get(key) instanceof Object[]) {
            Object[] arr = (Object[]) map.get(key);
            obj = request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    public Integer getInter(Object key) {
        return get(key) == null ? null : Integer.parseInt(get(key) + "");
    }

    public Double getDouble(Object key) {
        return get(key) == null ? 0.0 : Double.parseDouble(getString(key).isEmpty() ? "0.0" : getString(key));
    }

    public String getString(Object key) {
        return get(key) == null ? "" : (String) get(key);
    }

    public boolean getBoolean(Object key) {
        return get(key) == null ? false : (boolean) get(key);
    }

    public String getStringOrDefault(Object key, String defaultStr) {
        return get(key) == null ? defaultStr : (String) get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public Set entrySet() {
        return map.entrySet();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Set keySet() {
        return map.keySet();
    }

    @SuppressWarnings("unchecked")
    public void putAll(Map t) {
        map.putAll(t);
    }

    public int size() {
        return map.size();
    }

    public Collection values() {
        return map.values();
    }

    public String parsePage() {
        StringBuffer sb = new StringBuffer();
        Iterator<String> iteratorSet = this.keySet().iterator();
        while (iteratorSet.hasNext()) {
            String key = iteratorSet.next();
            sb.append(key).append("=")
                    .append(this.get(key)).append("&");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    /**
     * 简单PUT模式
     * 支持一次调用往指定对象中写入多个键值
     * TODO 需要保证键数组及值数组长度一致!
     *
     * @param keys   键数组
     * @param values 值数组
     * @return
     */
    public BaseData simplePut(String[] keys, Object... values) {
        if (keys.length == values.length) {
            for (int i = 0; i < keys.length; i++) {
                if (!StrUtil.isEmptyIfStr(keys)) {
                    this.put(keys[i], values[i]);
                }
            }
        }
        return this;
    }

}
