<template>
    <section>
    
        <el-tabs v-model="activeName2"  @tab-click="handleClick" type="border-card">
        <el-tab-pane label="Topology" name="tab_topology">
            <div id="us_lab_topology"></div>
        </el-tab-pane>
        <el-tab-pane label="Edit Topology" name="tab_topo_model">tab2</el-tab-pane>
        </el-tabs>
        <!-- <div id="us_lab_topology"></div> -->
    </section>
    
</template>

<script>
  import cytoscape from 'cytoscape';
  

  export default {
    data() {
      return {
        activeName2: 'tab_topology'
      };
    },
    methods: {
      handleClick(tab, event) {
        // console.log(tab, event);
      },
      drawDemo1(){

        //////////////////////////////

      var cy = cytoscape({
  container: document.getElementById('us_lab_topology'),
       layout: {
    name: 'cose',
    padding: 10,
    randomize: true
  },
  
  style: cytoscape.stylesheet()
    .selector('node')
      .css({
        'shape': 'data(faveShape)',
        'width': 'mapData(weight, 40, 80, 20, 60)',
        'content': 'data(name)',
        'text-valign': 'center',
        'text-outline-width': 2,
        'text-outline-color': 'data(faveColor)',
        'background-color': 'data(faveColor)',
        'color': '#fff'
      })
    .selector(':selected')
      .css({
        'border-width': 3,
        'border-color': '#333'
      })
    .selector('edge')
      .css({
        'curve-style': 'bezier',
        'opacity': 0.666,
        'width': 'mapData(strength, 70, 100, 2, 6)',
        'target-arrow-shape': 'triangle',
        'source-arrow-shape': 'circle',
        'line-color': 'data(faveColor)',
        'source-arrow-color': 'data(faveColor)',
        'target-arrow-color': 'data(faveColor)'
      })
    .selector('edge.questionable')
      .css({
        'line-style': 'dotted',
        'target-arrow-shape': 'diamond'
      })
    .selector('.faded')
      .css({
        'opacity': 0.25,
        'text-opacity': 0
      }),
  
  elements: {
    nodes: [
      { data: { id: 'j', name: 'Jerry', weight: 65, faveColor: '#6FB1FC', faveShape: 'triangle' } },
      { data: { id: 'e', name: 'Elaine', weight: 45, faveColor: '#EDA1ED', faveShape: 'ellipse' } },
      { data: { id: 'k', name: 'Kramer', weight: 75, faveColor: '#86B342', faveShape: 'octagon' } },
      { data: { id: 'g', name: 'George', weight: 70, faveColor: '#F5A45D', faveShape: 'rectangle' } }
    ],
    edges: [
      { data: { source: 'j', target: 'e', faveColor: '#6FB1FC', strength: 90 } },
      { data: { source: 'j', target: 'k', faveColor: '#6FB1FC', strength: 70 } },
      { data: { source: 'j', target: 'g', faveColor: '#6FB1FC', strength: 80 } },
     
      { data: { source: 'e', target: 'j', faveColor: '#EDA1ED', strength: 95 } },
      { data: { source: 'e', target: 'k', faveColor: '#EDA1ED', strength: 60 }, classes: 'questionable' },
      
      { data: { source: 'k', target: 'j', faveColor: '#86B342', strength: 100 } },
      { data: { source: 'k', target: 'e', faveColor: '#86B342', strength: 100 } },
      { data: { source: 'k', target: 'g', faveColor: '#86B342', strength: 100 } },
      
      { data: { source: 'g', target: 'j', faveColor: '#F5A45D', strength: 90 } }
    ]
  },

});
        /////////////////////////////

      },

      showTopologyTips(){
         this.$notify.info({
          title: 'Topology Tips',
          message: '(1). Zoom in or zoom out via mouse wheel. (2).  Hold  page to move. (3). Select the node to operate.',
          duration: 15000,
          offset: 130
        });
         


      }


    },
    mounted() {
      this.drawDemo1();
      this.showTopologyTips();

    }
  };
</script>
<style scoped lang="scss">
#us_lab_topology {
        width: 100%;
        height: 80vh;
        
        top: 0px;
        left: 0px;
    }

  
</style>