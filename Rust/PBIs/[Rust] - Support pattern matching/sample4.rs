fn main() {
    enum TrafficLight {
        Red,
        Green,
        Yellow,
    }
    
    fn enum_pattern_matching(light: TrafficLight) -> &'static str {
        match light {
            TrafficLight::Red => "Stop",
            TrafficLight::Green => "Go",
            TrafficLight::Yellow => "Slow down",
        }
    }
    
    }
    