
package com.abora.phoneexplorer.model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoneResponse implements Serializable {

    @SerializedName("DeviceName")
    @Expose
    private String deviceName;
    @SerializedName("Brand")
    @Expose
    private String brand;
    @SerializedName("technology")
    @Expose
    private String technology;
    @SerializedName("announced")
    @Expose
    private String announced;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("dimensions")
    @Expose
    private String dimensions;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("sim")
    @Expose
    private String sim;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("resolution")
    @Expose
    private String resolution;
    @SerializedName("card_slot")
    @Expose
    private String cardSlot;
    @SerializedName("loudspeaker_")
    @Expose
    private String loudspeaker;
    @SerializedName("sound_c")
    @Expose
    private String soundC;
    @SerializedName("wlan")
    @Expose
    private String wlan;
    @SerializedName("bluetooth")
    @Expose
    private String bluetooth;
    @SerializedName("gps")
    @Expose
    private String gps;
    @SerializedName("radio")
    @Expose
    private String radio;
    @SerializedName("usb")
    @Expose
    private String usb;
    @SerializedName("features_c")
    @Expose
    private String featuresC;
    @SerializedName("battery_c")
    @Expose
    private String batteryC;
    @SerializedName("colors")
    @Expose
    private String colors;
    @SerializedName("sensors")
    @Expose
    private String sensors;
    @SerializedName("cpu")
    @Expose
    private String cpu;
    @SerializedName("internal")
    @Expose
    private String internal;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("network_c")
    @Expose
    private String networkC;
    @SerializedName("chipset")
    @Expose
    private String chipset;
    @SerializedName("features")
    @Expose
    private String features;
    @SerializedName("protection")
    @Expose
    private String protection;
    @SerializedName("gpu")
    @Expose
    private String gpu;
    @SerializedName("nfc")
    @Expose
    private String nfc;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("sar")
    @Expose
    private String sar;
    @SerializedName("single")
    @Expose
    private String single;
    @SerializedName("triple")
    @Expose
    private String triple;
    @SerializedName("charging")
    @Expose
    private String charging;
    @SerializedName("models")
    @Expose
    private String models;
    @SerializedName("_2g_bands")
    @Expose
    private String _2gBands;
    @SerializedName("_3_5mm_jack_")
    @Expose
    private String _35mmJack;
    @SerializedName("_3g_bands")
    @Expose
    private String _3gBands;
    @SerializedName("_4g_bands")
    @Expose
    private String _4gBands;
    @SerializedName("memory_c")
    @Expose
    private String memoryC;
    @SerializedName("build")
    @Expose
    private String build;
    @SerializedName("dual_")
    @Expose
    private String dual;
    @SerializedName("sar_eu")
    @Expose
    private String sarEu;
    private final static long serialVersionUID = 4241810107244664771L;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getAnnounced() {
        return announced;
    }

    public void setAnnounced(String announced) {
        this.announced = announced;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getCardSlot() {
        return cardSlot;
    }

    public void setCardSlot(String cardSlot) {
        this.cardSlot = cardSlot;
    }

    public String getLoudspeaker() {
        return loudspeaker;
    }

    public void setLoudspeaker(String loudspeaker) {
        this.loudspeaker = loudspeaker;
    }

    public String getSoundC() {
        return soundC;
    }

    public void setSoundC(String soundC) {
        this.soundC = soundC;
    }

    public String getWlan() {
        return wlan;
    }

    public void setWlan(String wlan) {
        this.wlan = wlan;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public String getFeaturesC() {
        return featuresC;
    }

    public void setFeaturesC(String featuresC) {
        this.featuresC = featuresC;
    }

    public String getBatteryC() {
        return batteryC;
    }

    public void setBatteryC(String batteryC) {
        this.batteryC = batteryC;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getNetworkC() {
        return networkC;
    }

    public void setNetworkC(String networkC) {
        this.networkC = networkC;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getProtection() {
        return protection;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSar() {
        return sar;
    }

    public void setSar(String sar) {
        this.sar = sar;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getTriple() {
        return triple;
    }

    public void setTriple(String triple) {
        this.triple = triple;
    }

    public String getCharging() {
        return charging;
    }

    public void setCharging(String charging) {
        this.charging = charging;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String get2gBands() {
        return _2gBands;
    }

    public void set2gBands(String _2gBands) {
        this._2gBands = _2gBands;
    }

    public String get35mmJack() {
        return _35mmJack;
    }

    public void set35mmJack(String _35mmJack) {
        this._35mmJack = _35mmJack;
    }

    public String get3gBands() {
        return _3gBands;
    }

    public void set3gBands(String _3gBands) {
        this._3gBands = _3gBands;
    }

    public String get4gBands() {
        return _4gBands;
    }

    public void set4gBands(String _4gBands) {
        this._4gBands = _4gBands;
    }

    public String getMemoryC() {
        return memoryC;
    }

    public void setMemoryC(String memoryC) {
        this.memoryC = memoryC;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getDual() {
        return dual;
    }

    public void setDual(String dual) {
        this.dual = dual;
    }

    public String getSarEu() {
        return sarEu;
    }

    public void setSarEu(String sarEu) {
        this.sarEu = sarEu;
    }

}
