(import-rdf )
(import-rdf-files facts.rdf)
(load-compiled-dr-device rulebase.clp)
(go-dr-device)
(dr-device_export_rdf rulebase.ruleml export.rdf proof.ruleml is_speeding_on_town_road_lv3_with_accident is_speeding_on_town_road_lv1 is_speeding_on_town_road_lv2 to_pay_min to_pay_max max_imprisonment is_speeding_on_town_road_lv3 to_pay)
