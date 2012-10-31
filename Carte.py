class Carte():
    def __init__(self):
        pass
    
    
    
class Salle():
    def __init__(self):
        self.salle = list()
        self.chargeCarte()
    
    def chargeCarte(self):
        f = open('assets/map/map2.mp', 'r')
        
        f.readline()
        f.readline()
        f.readline()
        ligne = list()
        ligne = f.read()
        
        for i in ligne.splitlines():
            self.salle= list(ligne)
            print(self.salle[0])
        
if __name__ == '__main__':
    s = Salle()
        
        
        
    