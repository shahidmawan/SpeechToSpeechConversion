/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspeech;

/**
 *
 * @author Shahid
 */
public class ResponseObject {

    String TextFrom = "test";
    String TextTo = "test";
    long sec = 0;
    Double conf = 0.0;

    public ResponseObject(String textFrom, String textTo, long sec, Double conf) {
        this.TextFrom = textFrom;
        this.TextTo = textTo;
        this.sec = sec;
        this.conf = conf;
    }

    public String getTextFrom() {
        return TextFrom;
    }

    public String getTextTo() {
        return TextTo;
    }

    public long getSec() {
        return sec;
    }

    public Double getConf() {
        return conf;
    }

}
