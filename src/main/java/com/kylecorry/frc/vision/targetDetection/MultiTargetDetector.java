package com.kylecorry.frc.vision.targetDetection;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;

// TODO: Add better way to identify which detector found what target
public class MultiTargetDetector extends Detector<Target> {

    private List<Detector<? extends Target>> detectors;

    /**
     * Create a MultiTargetDetector to detect multiple types of targetDetection in an image.
     *
     * @param detectors The detector for each target to identify.
     */
    public MultiTargetDetector(List<Detector<? extends Target>> detectors) {
        this.detectors = detectors;
    }

    /**
     * Detect the targetDetection in the image.
     *
     * @param frame The image to detect targetDetection in.
     * @return The list of possible targetDetection ordered by confidence from greatest to least and by which detector found the target.
     */
    @Override
    public List<Target> detect(Mat frame) {
        List<Target> targets = new ArrayList<>();
        for (Detector<? extends Target> detector : detectors) {
            targets.addAll(detector.detect(frame));
        }
        return targets;
    }

}
