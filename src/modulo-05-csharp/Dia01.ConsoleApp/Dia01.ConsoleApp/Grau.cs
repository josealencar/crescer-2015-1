﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dia01.ConsoleApp
{
    internal enum Grau
    {
        [Description("Joven Padawan.")]
        PADAWAN,
        [Description("Cavaleiro!")]
        CAVALEIRO,
        [Description("Mestre Jedi!!!")]
        MESTRE
    }
}
